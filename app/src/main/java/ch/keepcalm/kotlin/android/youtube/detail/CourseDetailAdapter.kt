package ch.keepcalm.kotlin.android.youtube.detail

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.keepcalm.kotlin.android.youtube.lesson.CourseLessonActivity
import ch.keepcalm.kotlin.android.youtube.main.CourseLesson
import ch.keepcalm.recyclerview_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_lesson_row.view.*

class CourseDetailAdapter (val courseLessons: Array<CourseLesson>) : RecyclerView.Adapter<CourseLessonViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return courseLessons.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseLessonViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)

        return CourseLessonViewHolder(customView)

    }

    override fun onBindViewHolder(holder: CourseLessonViewHolder, position: Int) {
        val courseLesson = courseLessons.get(position)
        holder.view.textView_course_lesson_title.text = courseLesson.name
        holder.view.textView_course_lesson_title.text = courseLesson.name
        holder.view.textView_course_lesson_detail.text = "Episode #${courseLesson.number}\n" +
                "${courseLesson.duration}"

        Picasso.get().load(courseLesson.imageUrl).into(holder.view.imageView_course_lesson_thumbnail)

        holder?.courseLesson = courseLesson

    }


}

class CourseLessonViewHolder(val view: View, var courseLesson: CourseLesson? = null) : RecyclerView.ViewHolder(view){

    companion object {
        val COURSE_LESSON_LINK_KEY = "COURSE_LESSON_LINK"
    }
    init{
        view.setOnClickListener{
            val intent = Intent(view.context, CourseLessonActivity::class.java)
            intent.putExtra(COURSE_LESSON_LINK_KEY, courseLesson?.link)
            view.context.startActivity(intent)

        }
    }
}