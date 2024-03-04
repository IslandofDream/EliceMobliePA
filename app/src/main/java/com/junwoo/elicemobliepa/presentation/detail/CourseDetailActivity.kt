package com.junwoo.elicemobliepa.presentation.detail

import android.os.Bundle
import android.webkit.WebView
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.viewinterop.AndroidView
import com.junwoo.elicemobliepa.R
import com.junwoo.elicemobliepa.presentation.util.TestDummy
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
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

@AndroidEntryPoint
class CourseDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //CourseDetailScreen(model form server)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CourseDetailScreen(model: CouresDetailModel) {
        EliceMobliePATheme {
            Scaffold(topBar = {
                EliceTopBar(
                    model = EliceTopBarModel(
                        topBarLeftSection = TopBarLeftSection.BACK,
                        topBarRightSection = TopBarRightSection.NONE,
                        height = 56
                    ), onLeftClick = {}, onRightClick = {})
            })
            { innerPadding ->

                val courseDetailModel: CouresDetailModel // collectAsState
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
                            model.imageUrl?.let {
                                TitleAreaWithImage(
                                    logoUrl = model.logoUrl,
                                    imageUrl = model.imageUrl,
                                    title = model.title,
                                )
                            }
                                ?: TitleAreaWithoutImage(
                                    logoUrl = model.logoUrl,
                                    title = model.title,
                                    shortDescription = model.shortDescription!!
                                )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(16.dp)
                            )
                        }
                        // Description Area
                        item {
                            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                                model.description?.let {
                                    SubTitleWithDivider(subTitle = R.string.course_introduce)
                                    DescriptionArea(markdown = model.description)
                                }

                                SubTitleWithDivider(subTitle = R.string.course_curriculum)
                            }
                        }
                        // curriculumArea
                        itemsIndexed(model.lectures) { index, item ->
                            TimelineView(
                                title = item.first,
                                description = item.second,
                                index = index,
                                itemCount = model.lectures.size,
                            )
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
                            ), applied = false
                        ) { /*Enroll*/ }
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
        val parser = Parser.builder().build()
        val renderer = HtmlRenderer.builder().build()

        // Markdown을 HTML로 변환합니다.
        val document = parser.parse(markdown)
        val html = renderer.render(document)

        // WebView를 사용하여 HTML을 렌더링합니다.
        AndroidView(factory = { context ->
            WebView(context).apply {
                loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)
            }
        })
    }

    @Preview
    @Composable
    private fun PreviewCourseDeatilScreen(
        @PreviewParameter(CourseDeatilPreviewProvider::class) models: CouresDetailModel
    ) {
        EliceMobliePATheme {
            CourseDetailScreen(model = models)
        }
    }
}