package ch.keepcalm.kotlin.android.youtube.detail

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.keepcalm.recyclerview_android.R

class CourseDetailAdapter : RecyclerView.Adapter<CourseLessonViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseLessonViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)


//
//        val readView = View(parent?.context)
//        readView.setBackgroundColor(Color.BLACK)
//        readView.minimumHeight = 50

        return CourseLessonViewHolder(customView)

    }

    override fun onBindViewHolder(holder: CourseLessonViewHolder, position: Int) {
        //
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