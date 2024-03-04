package com.junwoo.elicemobliepa.presentation.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.presentation.widget.coursecard.CourseCard
import com.junwoo.elicemobliepa.presentation.widget.coursecard.CourseCardModel
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBar
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBarModel
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarLeftSection
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarRightSection
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

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

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(scrollState)
                ) {
                    //TODO collectAsLazyPagingItems
                    val list = listOf<CourseCardModel>()

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                    )
                    CourseSection(text = R.string.home_free_course, courseCards = list)
                    CourseSection(text = R.string.home_recommend_course, courseCards = list)
                    CourseSection(text = R.string.home_my_course, courseCards = list)
                }
            }
        }
    }

    @Composable
    private fun CourseSection(@StringRes text: Int, courseCards: List<CourseCardModel>) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
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
            style = EliceTheme.typography.homeTitle,
            color = EliceTheme.colors.black
        )
    }

    @Composable
    private fun CourseList(courseCards: List<CourseCardModel>) {
        LazyRow(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(courseCards) { _, course ->
                CourseCard(courseCardModel = course) {
                    //TODO 강의 상세조회 이동
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