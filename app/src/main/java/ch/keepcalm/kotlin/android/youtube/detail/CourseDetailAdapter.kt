package ch.keepcalm.kotlin.android.youtube.detail

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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



//        holder.view.textView_video_title.text = video.name
//        holder.view.textView_channel_name.text =  "${video.channel.name} • ${video.numberOfViews} Views \n${video.channel.numberOfSubscribers} Channel subscribers"

        Picasso.get().load(courseLesson.imageUrl).into(holder.view.imageView_course_lesson_thumbnail)
//        Picasso.get().load(video.channel.profileImageUrl).into(holder.view.imageView_channel_profile)

//        holder.video = video
    }


}

class CourseLessonViewHolder(val view: View) : RecyclerView.ViewHolder(view){
    init{
        view.setOnClickListener{
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}