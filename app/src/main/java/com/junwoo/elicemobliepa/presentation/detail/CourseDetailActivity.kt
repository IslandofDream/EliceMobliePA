package com.junwoo.elicemobliepa.presentation.detail

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.presentation.home.HomeActivity
import com.junwoo.elicemobliepa.presentation.util.UiState
import com.junwoo.elicemobliepa.presentation.widget.button.SignUpButton
import com.junwoo.elicemobliepa.presentation.widget.button.SignUpButtonModel
import com.junwoo.elicemobliepa.presentation.widget.curriculum.TimelineView
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBar
import com.junwoo.elicemobliepa.presentation.widget.topbar.EliceTopBarModel
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarLeftSection
import com.junwoo.elicemobliepa.presentation.widget.topbar.TopBarRightSection
import com.junwoo.elicemobliepa.ui.theme.EliceMobliePATheme
import com.junwoo.elicemobliepa.ui.theme.EliceTheme
import dagger.hilt.android.AndroidEntryPoint
import dev.jeziellago.compose.markdowntext.MarkdownText

@AndroidEntryPoint
class CourseDetailActivity : ComponentActivity() {

    companion object {
        private const val OFFSET = 0
        private const val COUNT = 40
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val detailViewModel by viewModels<CourseDetailViewModel>()

        setContent {

            intent.getIntExtra(HomeActivity.COURSE_ID_KEY, 0).let { id ->
                detailViewModel.getCourseDetail(courseId = id)
                detailViewModel.getLectureList(
                    courseId = id,
                    offset = OFFSET,
                    count = COUNT
                )
                detailViewModel.checkApplied(id)
                CourseDetailScreen(viewModel = detailViewModel, courseId = id)
            }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CourseDetailScreen(viewModel: CourseDetailViewModel, courseId: Int) {
        EliceMobliePATheme {
            Scaffold(topBar = {
                EliceTopBar(
                    model = EliceTopBarModel(
                        topBarLeftSection = TopBarLeftSection.BACK,
                        topBarRightSection = TopBarRightSection.NONE,
                        height = 56
                    ), onLeftClick = {
                        finish()
                    }, onRightClick = {})
            })
            { innerPadding ->

                val courseDetailUiState =
                    viewModel.detailCourseStateFlow.collectAsStateWithLifecycle().value
                val lectureUiState =
                    viewModel.lectureListStateFlow.collectAsStateWithLifecycle().value

                val isLoading = viewModel.isLoadingStateFlow.collectAsStateWithLifecycle().value
                val isApplied = viewModel.appliedStateFlow.collectAsStateWithLifecycle().value

                Column {
                    // infinity maxinum height 방지
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f)
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Top
                    ) {
                        //Title Area
                        item {
                            when (courseDetailUiState) {
                                is UiState.Loading -> {
                                    LoadingBar()
                                }

                                is UiState.Success -> {
                                    if (courseDetailUiState.data.imageUrl.isNullOrBlank()) {
                                        TitleAreaWithoutImage(
                                            logoUrl = courseDetailUiState.data.logoUrl,
                                            title = courseDetailUiState.data.title,
                                            shortDescription = courseDetailUiState.data.shortDescription!!
                                        )

                                    } else {
                                        TitleAreaWithImage(
                                            logoUrl = courseDetailUiState.data.logoUrl,
                                            imageUrl = courseDetailUiState.data.imageUrl,
                                            title = courseDetailUiState.data.title,
                                        )
                                    }
                                }

                                else -> Unit
                            }

                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(16.dp)
                            )
                        }
                        // Description Area
                        item {
                            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                                when (courseDetailUiState) {
                                    is UiState.Loading -> {
                                        LoadingBar()
                                    }

                                    is UiState.Success -> {
                                        courseDetailUiState.data.description?.let {
                                            if (courseDetailUiState.data.description.isNotBlank()) {
                                                SubTitleWithDivider(subTitle = R.string.course_introduce)
                                                DescriptionArea(markdown = courseDetailUiState.data.description)
                                            }
                                        }
                                    }

                                    else -> Unit
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                SubTitleWithDivider(subTitle = R.string.course_curriculum)
                            }
                        }
                        // curriculumArea
                        when (lectureUiState) {
                            is UiState.Loading -> {
                                item {
                                    LoadingBar()
                                }
                            }

                            is UiState.Success -> {
                                itemsIndexed(lectureUiState.data) { index, item ->
                                    TimelineView(
                                        title = item.title!!,
                                        description = item.description!!,
                                        index = index,
                                        itemCount = lectureUiState.data.size,
                                    )
                                }
                            }

                            else -> {
                                Unit
                            }
                        }

                    }
                    Surface {
                        SignUpButton(
                            model = SignUpButtonModel(
                                enrollText = R.string.button_enroll,
                                enrollColor = EliceTheme.colors.purple,
                                withdrawalText = R.string.button_withdrawal,
                                withdrawalColor = EliceTheme.colors.cherryRed,
                                textColor = EliceTheme.colors.white
                            ), applied = isApplied,
                            isLoading = isLoading
                        ) { viewModel.singUpCourse(courseId, isApplied) }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

    @Composable
    private fun SubTitleWithDivider(@StringRes subTitle: Int) {
        Column {
            Text(
                text = stringResource(id = subTitle),
                style = EliceTheme.typography.courseSubTitle,
                color = EliceTheme.colors.purple
            )
            Divider(
                color = EliceTheme.colors.gray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .height(1.dp)
            )
        }
    }

    @Composable
    private fun DescriptionArea(markdown: String) {
        MarkdownText(markdown = markdown)
        Spacer(modifier = Modifier.height(8.dp))
    }

    @Composable
    private fun LoadingBar() {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = EliceTheme.colors.lightGray,
        )
    }

    @Preview
    @Composable
    private fun PreviewCourseDetailScreen(
        @PreviewParameter(CourseDeatilPreviewProvider::class) models: CouresDetailModel
    ) {
        EliceMobliePATheme {
            //CourseDetailScreen(model = models)
        }
    }
}