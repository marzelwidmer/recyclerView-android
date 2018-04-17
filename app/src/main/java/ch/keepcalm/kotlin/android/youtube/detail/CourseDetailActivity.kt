package ch.keepcalm.kotlin.android.youtube.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import ch.keepcalm.kotlin.android.youtube.main.CourseLesson
import ch.keepcalm.kotlin.android.youtube.main.CustomerViewHolder
import ch.keepcalm.recyclerview_android.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

/**
 * Created by  marcelwidmer on 16.04.18 - 16/04/April
 */
class CourseDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recycleView_main.layoutManager = LinearLayoutManager(this)

        // change nav bar title
        val videoTitle = intent.getStringExtra(CustomerViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = videoTitle

        fetchJson()
    }


    private fun fetchJson() {
        println("Attemping to Fetch JSON")

        val videoId = intent.getStringExtra(CustomerViewHolder.VIDEO_ID_KEY)
        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id=${videoId}"

        val request = Request.Builder().url(courseDetailUrl).build()
        val client = OkHttpClient()

        // in MainActivity I can't execute I have to queue it.
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val courseLessons = gson.fromJson(body, Array<CourseLesson>::class.java)

                // android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
                runOnUiThread {
                    recycleView_main.adapter = CourseDetailAdapter(courseLessons)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                error("Failed to execute request")
            }
        })
    }
}

