package com.junwoo.elicemobliepa.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.presentation.detail.CourseDetailActivity
import com.junwoo.elicemobliepa.presentation.util.Spacer8
import com.junwoo.elicemobliepa.presentation.widget.coursecard.CourseCard
import com.junwoo.elicemobliepa.presentation.widget.loading.CircularLoading
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBar
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBarModel
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarLeftSection
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarRightSection
import com.junwoo.elicemobliepa.ui.theme.EliceMobilePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    companion object {
        const val COURSE_ID_KEY = "course_id"
    }

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.fetchMyCourses()
        // 다른 과목들은 실시간으로 변할 소요가 적어서 내 학습에 한해서 LazyRow 갱신하도록 처리
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HomeScreen() {
        EliceMobilePATheme {
            Scaffold(topBar = {
                EliceTopBar(
                    model = EliceTopBarModel(
                        topBarLeftSection = TopBarLeftSection.LOGO,
                        topBarRightSection = TopBarRightSection.SEARCH,
                        height = 64
                    ), onLeftClick = {}, onRightClick = { /*Mock Up*/ })
            })
            { innerPadding ->

                val scrollState = rememberScrollState()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(scrollState)
                ) {

                    val freeCourses = homeViewModel.freeCourses.collectAsLazyPagingItems()
                    val recommendCourses = homeViewModel.recommendCourses.collectAsLazyPagingItems()
                    val myCourses = homeViewModel.myCourses.collectAsLazyPagingItems()

                    Spacer8()
                    CourseSection(text = R.string.home_free_course, courseCards = freeCourses)
                    CourseSection(
                        text = R.string.home_recommend_course,
                        courseCards = recommendCourses
                    )
                    CourseSection(text = R.string.home_my_course, courseCards = myCourses)
                }
            }
        }
    }

    @Composable
    private fun CourseSection(
        @StringRes text: Int,
        courseCards: LazyPagingItems<CourseItemEntity>
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            CourseSectionTitle(text = text)
            CourseList(courseCards = courseCards)
            Spacer8()
        }
    }

    @Composable
    private fun CourseSectionTitle(@StringRes text: Int) {
        Text(
            text = stringResource(id = text),
            style = EliceTheme.typography.homeSectionTitle,
            color = EliceTheme.colors.black
        )
    }

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

    @Composable
    fun EmptyContent() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_course_empty),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = R.string.course_empty),
                style = EliceTheme.typography.homeTitle,
                color = EliceTheme.colors.gray,
            )
        }
    }

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

    @Preview
    @Composable
    private
    fun PreviewHomeScreen() {
        HomeScreen()
    }
}