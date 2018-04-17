package ch.keepcalm.kotlin.android.youtube.lesson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ch.keepcalm.kotlin.android.youtube.detail.CourseLessonViewHolder
import ch.keepcalm.recyclerview_android.R
import kotlinx.android.synthetic.main.activity_course_lesson.*

/**
 * Created by  marcelwidmer on 17.04.18
 */
class CourseLessonActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)
//        webview_course_lesson.setBackgroundColor(Color.YELLOW)
        webview_course_lesson.settings.javaScriptEnabled = true
        webview_course_lesson.settings.loadWithOverviewMode = true
        webview_course_lesson.settings.useWideViewPort = true
        val courseLink = intent.getStringExtra(CourseLessonViewHolder.COURSE_LESSON_LINK_KEY)
        webview_course_lesson.loadUrl(courseLink)

    }
}