# 엘리스 Mobile Team PA

<aside>
💡 해당 프로젝트는 local.properties를 통해서 BaseUrl을 관리하였으므로 적절한 local.properties가 필요합니다.

</aside>

### 개발방식

Android jetpack Compose 기반으로 구성하였습니다. 아키텍처 구조는 클린아키텍처 기반으로 하였으며 그에 따라서 패키징 또한 Data / Domain / Presentation 으로 나누었습니다.

### 기술스택

- Jetpack Compose
- Jetpack Paging3
- Hilt
- Kotlin Couroutine
- Koltin Flow
- Coil
- Retrofit2 (Gson)
- Okhttp
- Preference DataStore

### 커밋 컨벤션

```kotlin
[type] subject
- body
```

- Type종류
1. Feat : 기능 추가
2. Refactor : 코드 리팩토링 / 오타수정
3. Style : 화면관련 속성 / 배치 수정
4. Fix : 버그 수정
5. Add : 이미지 혹은 Theme관련 코드 추가
6. Config : 라이브러리 사용을 위한 의존성 추가 혹은 gradle 및 manifest 수정
7. Docs: 문서 수정

해당 커밋에서 무엇을 하고 있는지 명확하게 작성하려고 했으며 더 자세한 사항이 있을 경우 body부분에 더 자세한 내용을 작성하였습니다.

## DI

의존성 주입을 위해서 Hilt를 사용하였습니다.

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

@Provides
@Singleton
fun provideDetailDataSource(
    eliceApi: EliceApi
): DetailCourseDataSource {
    return DetailCourseDataSourceImpl(eliceApi)
}
...

@Singleton
@Provides
fun provideEliceRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL) //local.properties
      .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

@Singleton
@Provides
fun provideEliceService(eliceService: Retrofit): EliceApi {
    return eliceService.create(EliceApi::class.java)
}

```

다음과 같이 Retrofit , DataStore등 DataSource들을 Singleton으로 주입합니다.

```kotlin
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

@Binds
@Singleton
abstract fun bindToHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

...

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

@Binds
@ViewModelScoped
abstract fun bindToFetchCourseItems(fetchCourseItemsUseCaseImpl: FetchCourseItemsUseCaseImpl): FetchCourseItemsUseCase

@Binds
@ViewModelScoped
abstract fun bindToGetCourseDetail(getCourseDetailUseCaseImpl: GetCourseDetailUseCaseImpl): GetCourseDetailUseCase
```

또한 Repository와 UseCase 또한 주입합니다. UseCase는 ViewModel에서만 사용하므로 그에 대한 annotation을 사용하였습니다.

---

## Data

요구사항에서 과목조회 리스트는 infinity scroll을 요구하였으므로 Paging3를 사용하여 서버로부터 데이터를 받아왔습니다.

### Service

```kotlin
@GET("course/list/")
suspend fun getCourses(
    @Query("filter_is_recommended") filterIsRecommended: Boolean? = null,
    @Query("filter_is_free") filterIsFree: Boolean? = null,
    @Query("filter_conditions") filterConditions: String? = null, // JSON String
    @Query("offset") offset: Int,
    @Query("count") count: Int,
): CourseListDTO
```

다음과 같이 parameter에 따라서 추천과목, 무료과목, 필터조건에 따른 내 학습 을 가져올 수 있도록 해주었고 이 세가지의 query를 nullable하게 만들어 필요한 query만 넘어가게 해주었습니다.

### PagingSource

Paging을 사용하는 경우입니다.

```kotlin
override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CourseItemEntity> {
    return try {
        val position = params.key ?: STARTING_PAGE_INDEX
        val response = service.getCourses(
            offset = (position - 1) * params.loadSize, //10개씩 load하므로 offset은 position에 따라 10씩 증가
            count = params.loadSize,
            filterIsRecommended = filterIsRecommended,
            filterIsFree = filterIsFree,
            filterConditions = filterConditions
        ).let {
            courseListMapper.map(it)
        }

        LoadResult.Page(
            data = response,
            prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
            nextKey = if (response.isEmpty()) null else position + (params.loadSize / 10)
        )
    } catch (exception: Exception) {
        LoadResult.Error(exception)
    }
}
```

요구사항은 10개 단위로 정보를 가져와야 하므로 LoadParam에 10이 들어오도록 하여 offset이 0, 10 ,20 단위로 늘어나도록 해주었습니다. 이렇게 받아온 정보는 mapper를 통해 실제 사용할 데이터만을 추려서 entity형태로 변환해주었습니다. 

```kotlin
interface BaseMapper<From, To> {
    fun map(from: From): To
}
```

Mapper의 가독성을 위해서 다음과 같이 인터페이스를 하나 만들었습니다.

```kotlin
class CourseListMapper : BaseMapper<CourseListDTO, List<CourseItemEntity>> {
    override fun map(from: CourseListDTO): List<CourseItemEntity> =
        from.courses?.let {
            it.asSequence().map { field ->
                CourseItemEntity(
                    id = field?.id ?: 0,
                    imageFileUrl = field?.imageFileUrl,
                    logoFileUrl = field?.logoFileUrl ?: "",
                    title = field?.title ?: "",
                    shortDescription = field?.shortDescription ?: "",
                    tags = field?.tags?.map { tag -> tag?.name }?.toImmutableList() ?: listOf()
                )
            }
        }?.toList() ?: listOf()
}
```

이때, 성능상 큰 차이는 없지만 `CourseListDTO` 내부에 사용하지 않는 데이터가 많으므로 iterator 대신 필요한 요소만 추출하는 sequence를 사용하여 map을 통해 DTO를 entity로 변환 해주었습니다. 

### Repository with PaingData

```kotlin
class HomeRepositoryImpl @Inject constructor(
    private val eliceService: EliceApi,
    private val gson: Gson
) : HomeRepository {

    override fun fetchCourseItems(
        filterIsRecommended: Boolean?,
        filterIsFree: Boolean?,
        filterConditions: List<Int>?
    ): Flow<PagingData<CourseItemEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constant.PAGING_SIZE,
                initialLoadSize = Constant.PAGING_SIZE
            ),
            pagingSourceFactory = {
                val filterConditionQuery = filterConditions?.let {
                    gson.toJson(mapOf("course_ids" to filterConditions))
                }
                CoursePagingSource(
                    service = eliceService,
                    filterIsRecommended = filterIsRecommended,
                    filterIsFree = filterIsFree,
                    filterConditions = filterConditionQuery,
                    CourseListMapper()
                )
            }
        ).flow
    }
}
```

PagingSource의 fetch함수를 호출 합니다. 이때 매개변수를 통해 PagingSize와 initalLoadsize를 조절 할 수 있으며 filterCondition 쿼리 같은 경우에는 json 형태로 전달해야 하므로 주입받은 Gson객체를 통해 이전에 미리 DataStore에 List<Int> 형태로 저장해두었던 정보를 course_ids 를 키값으로 갖는 Json형태로 PagingSource에 전달합니다. 또한 flow를 반환하는 형태를 통해 Presentation까지 비동기적인 데이터 스트림 형태로 데이터를 전달합니다.

---

### DataSoure

Paging을 사용하지 않는 경우 입니다.

```kotlin
@GET("course/get/")
suspend fun getCourseDetail(
    @Query("course_id") courseId: Int
): CourseDetailDTO
```

```kotlin
class DetailCourseDataSourceImpl @Inject constructor(
    private val eliceApi: EliceApi
) : DetailCourseDataSource {
    override fun getCourseDetail(courseId: Int): Flow<CourseDetailDTO> {
        return flow {
            emit(eliceApi.getCourseDetail(courseId = courseId))
        }.safeCallApi()
    }
...
}
```

다음과 같이 EliceAPI interface를 기반으로 한 Retrofit 객체를 주입받은후 flow형태로 반환합니다.

### SafeCallApi()

```kotlin
fun <T> Flow<T>.safeCallApi(): Flow<T> {
    return this.flowOn(Dispatchers.IO).catch {
        throw it
    }.retry(3) {
        if (it is HttpException) {
            delay(1000)
            true
        } else {
            delay(1000)
            true
        }

    }
}
```

Flow의 확장함수 형태로 만들어 HttpExceotion과 같이 예상치 못한 에러의 경우 1초 간격으로 3번정도 재시도 하도록 해주었습니다.

### Repository with ApiResult

Presentation까지 서버로 부터 받은 데이터를 전달하기 위해 ApiResult 라는 sealedClass를 사용합니다.

```kotlin
sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error<T>(val message: String) : ApiResult<T>()
}
```

Success의 경우 데이터가 Error의 경우 에러 메세지가 들어가도록 하였습니다.

```kotlin
class DetailRepositoryImpl @Inject constructor(
    private val detailDataSource: DetailCourseDataSource
) : DetailRepository {
    override fun getCourseDetail(courseId: Int): Flow<ApiResult<CourseDetailEntity>> {
        return flow {
            detailDataSource.getCourseDetail(courseId = courseId).catch {
                emit(ApiResult.Error(it.toString()))
            }.collect {
                emit(ApiResult.Success(CourseDetailMapper().map(it)))
            }
        }
    }
...
}
```

주입받은 DataSource를 통해 데이터를 요청하고 이때 exception이 발생하면 catch 구문을 통해 exception을 ApiResult에 감싸서 비정상종료를 방지하고 이후 Presentation에서 에러 사실을 알도록 설계하였습니다. 정상인 경우 ApiResult.Success에 mapper로 변환된 entity를 넣어서 방출합니다.

---

### Repository with PreferenceDataStore

해당프로젝트에는 수강신청한 과목을 저장해야합니다. 따라서 DataStore를 채택하였고 이를 제어하는 Repository입니다.

```kotlin
class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val gson: Gson
) : DataStoreRepository {

    override suspend fun saveMyCourseList(list: List<Int>) {
        val json = gson.toJson(list)
        dataStore.edit { preferences ->
            preferences[Constant.DATASTORE_KEY] = json
        }
    }

    override fun getMyCourseList(): Flow<List<Int>> {
        return dataStore.data.catch {
            throw it
        }.map { preferences ->
            val json = preferences[Constant.DATASTORE_KEY] ?: ""
            if (json.isNotEmpty()) {
                val type = object : TypeToken<List<Int>>() {}.type
                gson.fromJson<List<Int>>(json, type)
            } else {
                emptyList()
            }
        }
    }
}

```

DataStore를 제어하는 Repository 입니다. 이 정보들은 이후 과목조회 API에 쓰여야 하므로 List<Int>형태로 저장하였으며 저장 함수는 비동기적으로 처리되므로 suspend 키워드를 붙여주었습니다.

---

## Domain

### Entity

```kotlin
data class CourseDetailEntity (
    val imageUrl: String?,
    val logoUrl: String,
    val description: String?,
    val title:String,
    val shortDescription:String?,
)
```

다음과 같이 entity는 서버에서 받아오는 DTO와는 다르게 필요한 정보들만 담을 수 있도록 간소화 하였습니다.

### UseCase

```kotlin
class GetCourseDetailUseCaseImpl @Inject constructor(private val detailRepository: DetailRepository) :
    GetCourseDetailUseCase {
    override fun invoke(courseId: Int): Flow<ApiResult<CourseDetailEntity>> {
        return detailRepository.getCourseDetail(courseId = courseId)
    }
}
```

Presentation에서 서버호출을 위해서 사용되는 UseCase입니다. Repository를 주입받고 적절한 매개변수와 함께 함수를 호출합니다.

---

## Presentation

### Widget

이번 프로젝트에서는 화면이 2개였지만 이후 확장성 혹은 재사용성을 고려한다는 가정하에 공통적인 요소들은 최대한 widget 패키지에 따로 분리하여 만들었습니다. 강의과목카드뷰, 버튼, 로딩인디케이터, 탑바등이 여기에 해당됩니다.

### WidgetModel

```kotlin
data class SignUpButtonModel(
    @StringRes val enrollText: Int,
    val enrollColor: Color,
    val withdrawalColor: Color,
    @StringRes val withdrawalText: Int,
    val textColor: Color,
)
```

이러한 Widget들에 대해서는 data class를 통한 model을 만들어 주었습니다. 이를 통해 재사용성 및 확장성과 이후 프리뷰를 간편하게 해주기 위함입니다.

### Preview

```kotlin
@Composable
@Preview(device = Devices.PHONE)
private fun PreViewHomeCourseCard(
    @PreviewParameter(CourseCardPreviewProvider::class) courseCardModel: CourseItemEntity
) {
    EliceMobilePATheme {
        CourseCard(courseCardModel) {}
    }
}
```

```kotlin
class CourseCardPreviewProvider : PreviewParameterProvider<CourseCardModel> {
    override val values: Sequence<CourseCardModel>
        get() = sequenceOf(
          CourseCardModel(...)
...
}
```

다음과 같이 PreviewParameterProvider를 통하여 여러 모델을을 한꺼번에 프리뷰 및 테스트에 용이하게 만들었습니다.

```kotlin
@Preview(device = Devices.PHONE)
@Composable
private fun CurriculumPreview...

@Preview(device = Devices.FOLDABLE)
@Composable
private fun CurriculumPreviewFoldable...

@Preview(device = Devices.TABLET)
@Composable
private fun CurriculumPreviewTablet ...
```

또한 일부 가변적이거나 여러기기 대응에 대한 프리뷰가 필요할때는 @Preview의 Device 기능을 사용하였습니다.

---

### Image

이번 프로젝트에서는 Url을 통한 이미지를 로드하는 경우가 많았습니다. 이때 Compose지원 및 Kotlin 기반으로 사용되는 Coil을 사용하기로 하였습니다. 

```kotlin
AsyncImage(
    model = url,
    contentDescription = null,
    modifier = Modifier
        .width(200.dp)
        .height(100.dp)
        .clip(RoundedCornerShape(10.dp)),
    placeholder = painterResource(id = R.drawable.image_placeholder_aspect_ratio_24),
    error = painterResource(id = R.drawable.image_error)
)
```

다음과 같이 Coil의 Composable중 하나인 AsyncImage를 사용했으며 placeholder, error등도 추가해 주었습니다.

### LazyLayout

과목카드, 커리큘럼등 동적으로 개수가 변하는 화면을 위해서 LazyLayout을 사용하였습니다. 

```kotlin
@Composable
    fun CourseCardsRow(courseCards: LazyPagingItems<CourseItemEntity>) {
        LazyRow(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(courseCards.itemCount) { index ->
                courseCards[index]?.let { courseItem ->
                    CourseCard(courseCardModel = courseItem) {
                        startActivity(
                            Intent(this@HomeActivity, CourseDetailActivity::class.java)
                                .putExtra(COURSE_ID_KEY, courseCards[index]!!.id)
                        )
                    }
                }
            }
        }
    }
```

다음과 같이 PagingItem도 LazyRow를 통해 horizontal scroll이 가능한 형태로 표시됩니다. PagingItem뿐만 아니라 다른 동적개수의 Composable객체 또한 표현 가능합니다.

### Canvas

과목상세조회 화면중 커리큘럼 부분은 수업의 개수와 길이가 데이터에 따라서 디자인이 변합니다. 좌측에는 원과 그사이를 잇는 선이 필요하므로 이를 데이터에 따라서 자연스럽게 표현하기 위해 Canvas를 사용하였습니다.

```kotlin
// TimeLine을 위한 원과 선을 그릴 Canvas
Canvas(modifier = Modifier.align(Alignment.TopStart)) {
    val circleRadius = circleSize.toPx() / 2
    val spaceWithTopAndCircle = 14.dp.toPx()
    val lineStart = Offset(circleRadius, (circleRadius * 2) + spaceWithTopAndCircle)
    val lineEnd = Offset(circleRadius, height.toFloat() + spaceWithTopAndCircle)

    // 선 그리기
    // 마지막 원의 경우 선을 그리지 않음
    if (model.index < model.itemCount - 1) {
        drawLine(
            color = timeLineColor,
            start = lineStart,
            end = lineEnd,
            strokeWidth = lineWidth.toPx()
        )
    }
    // 원 그리기
    drawCircle(
        color = timeLineColor,
        radius = circleRadius,
        center = Offset(circleRadius, circleRadius + spaceWithTopAndCircle),
        style = Stroke(width = 2.0F)
    )
}
```

다음과 같이 아이템의 index에 따라 원을 그리고 그 사이를 잇는 선을 높이에 맞추어 그려주는 작업을 진행하였습니다.

### Button

수강신청 버튼은 별도의 API없이 수강신청 기능을 동작해야 합니다. 따라서 DataStore를 사용하였고 그것을 기반으로 버튼의 색이 변하도록 하였습니다.

```kotlin
val bgColor = if (applied) model.withdrawalColor else model.enrollColor
val text =
  if (applied) stringResource(id = model.withdrawalText) else stringResource(id = model.enrollText)

var lastClickTime by remember { mutableStateOf(0L) }

Button(
  onClick = {
      if ((SystemClock.elapsedRealtime() - lastClickTime) > debounceInterval) {
          lastClickTime = SystemClock.elapsedRealtime()
          onClick()
      }
  },
```

또한 너무 과도한 DataStore 작업 방지를 위해 짧은 시간내에 여러 번의 클릭또한 방지하였습니다.

---

### ViewModel with PaingData

```kotlin
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchCourseItemsUseCase: FetchCourseItemsUseCase,
    private val getSavedMyCourseListUseCase: GetSavedMyCourseListUseCase
) : ViewModel() {

    private val _freeCourses = MutableStateFlow<PagingData<CourseItemEntity>>(PagingData.empty())
    val freeCourses = _freeCourses.asStateFlow()
...
    private fun fetchAndSetCourseItems(
...
    ) = viewModelScope.launch {
        runCatching {
            fetchCourseItemsUseCase(
                filterIsRecommended = filterIsRecommended,
                filterIsFree = filterIsFree,
                filterConditions = filterConditions
            )
        }.onSuccess {
            it.collect { pagingData ->
                stateFlow.value = pagingData
            }
        }.onFailure {
            throw it
        }
    }
}
```

뷰모델에서는 주입받은 UseCase를 통해서 서버호출을 합니다. 코루틴인 viewModelScope를 통해 비동기 작업을 하고 작업을 성공하면 StateFlow에 PagingData를 담습니다.

```kotlin
val freeCourses = homeViewModel.freeCourses.collectAsLazyPagingItems()
```

액티비티에서는 다음과 같이 flow을 수집하고 Paging 사용을 위해 PagingItem으로 변환 합니다.

```kotlin
@Composable
private fun CourseList(courseCards: LazyPagingItems<CourseItemEntity>) {
    when {
        courseCards.loadState.refresh is LoadState.Loading -> {
            CircularLoading(220)
        }

        courseCards.itemCount == 0 -> {
            EmptyContent()
        }

        else -> {
            CourseCardsRow(courseCards)
        }
    }
}
```

페이징의 상태에 따라서 적절한 화면이 composition됩니다. 

### UiState

```kotlin
sealed class UiState<out T> {   // Use Sealed Class
    object Init : UiState<Nothing>()
    //초기상태
    object Loading : UiState<Nothing>()
    //로딩상태
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val error: String) : UiState<Nothing>()
}
```

flow를 통해서 들어오는 데이터는 비동기이므로 UI는 해당 비동기 작업중과 서버호출간 에러발생에 대해서 적절한 대응을 해야합니다. 그렇기때문에 SealedClass를 통해서 다음과 같이 UI의 상태를 정의하여 View가 적절한 화면을 띄우도록 설계하였습니다.

### ViewModel With UiState, StateFlow

```kotlin
class CourseDetailViewModel @Inject constructor(
    private val getCourseDetailUseCase: GetCourseDetailUseCase,
...
) : ViewModel() {

    private val _detailCourseStateFlow = MutableStateFlow<UiState<CourseDetailEntity>>(UiState.Init)
    val detailCourseStateFlow = _detailCourseStateFlow.asStateFlow()
...
    fun getCourseDetail(courseId: Int) {
        viewModelScope.launch {
            _detailCourseStateFlow.value = UiState.Loading
            kotlin.runCatching {
                getCourseDetailUseCase(courseId = courseId)
            }.onSuccess {
                it.collect { collect ->
                    when (collect) {
                        is ApiResult.Success -> {
                            _detailCourseStateFlow.value = UiState.Success(collect.data)
                        }

                        is ApiResult.Error -> {
                            _detailCourseStateFlow.value = UiState.Error(collect.message)
                        }
                    }
                }
            }.onFailure {
                throw it
            }
        }
    }
```

서버에서 받은 데이터를 StateFlow를 통해 저장합니다. UiState의 상태는 최초 호출 때 Loading 상태가 되며 이후, ApiResult 결과에 따라서 UiState.Success 혹은 UiState.Error 상태가 됩니다.

```kotlin
val courseDetailUiState =
    viewModel.detailCourseStateFlow.collectAsStateWithLifecycle().value

@Composable
private fun TitleArea(courseDetailUiState: UiState<CourseDetailEntity>) {
    when (courseDetailUiState) {
        is UiState.Loading -> {
            CircularLoading(LOADING_SIZE)
        }

        is UiState.Success -> {
						...
        } //TODO is UiState.Error->{}

        else -> Unit
    }

}
```

이후 액티비티에서는 collectAsStateWithLifeCycle을 통해 flow를 수집하고 이에 따라서 상태에 따른 적절한 composition 발생하도록 하였습니다. 

```kotlin
override fun onResume() {
    super.onResume()
    homeViewModel.fetchMyCourses()
    // 다른 과목들은 실시간으로 변할 소요가 적어서 내 학습에 한해서 LazyRow 갱신하도록 처리
}
```

또한 생명주기를 활용하여 화면전환간 갱신이 필요한 데이터도 조절해주었습니다.
