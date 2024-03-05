package com.junwoo.elicemobliepa.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.domain.entity.CourseItemEntity
import com.junwoo.elicemobliepa.presentation.detail.CourseDetailActivity
import com.junwoo.elicemobliepa.presentation.widget.coursecard.CourseCard
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBar
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBarModel
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarLeftSection
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarRightSection
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    companion object {
        const val COURSE_ID_KEY = "course_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HomeScreen() {
        EliceMobliePATheme {
            Scaffold(topBar = {
                EliceTopBar(
                    model = EliceTopBarModel(
                        topBarLeftSection = TopBarLeftSection.LOGO,
                        topBarRightSection = TopBarRightSection.SEARCH,
                        height = 64
                    ), onLeftClick = {}, onRightClick = { //Mock Up
                    })
            })
            { innerPadding ->

                val scrollState = rememberScrollState()
                val homeViewModel by viewModels<HomeViewModel>()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(scrollState)
                ) {
                    val freeCourses = homeViewModel.getCourses(
                        filterIsFree = true
                    ).collectAsLazyPagingItems()

                    val recommendCourses = homeViewModel.getCourses(
                        filterIsRecommended = true
                    ).collectAsLazyPagingItems()

                    val myCourses = homeViewModel.getCourses(
                        filterCondition = true
                    ).collectAsLazyPagingItems()

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
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
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )
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
        if (courseCards.loadState.refresh is LoadState.Loading) {
            // 초기 로딩 중인 경우 로딩 인디케이터 표시
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .wrapContentSize(Alignment.Center),
                color = EliceTheme.colors.lightGray,
            )
        } else {
            LazyRow(
                modifier = Modifier.padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(courseCards.itemCount) { course ->
                    CourseCard(courseCardModel = courseCards[course]!!) {
                        startActivity(
                            Intent(this@HomeActivity, CourseDetailActivity::class.java)
                                .putExtra(COURSE_ID_KEY, courseCards[course]!!.id)
                        )
                    }

                    courseCards.apply {
                        when (loadState.append) {
                            is LoadState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.width(64.dp),
                                    color = EliceTheme.colors.lightGray,
                                )
                            }

                            else -> Unit
                        }
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