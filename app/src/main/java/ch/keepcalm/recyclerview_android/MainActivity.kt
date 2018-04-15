package ch.keepcalm.recyclerview_android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        recycleView_main.setBackgroundColor(Color.LTGRAY)

        recycleView_main.layoutManager = LinearLayoutManager(this)
//        recycleView_main.adapter = MainAdapter()
        fetchJson()
    }

    fun fetchJson() {
        println("Attemping to Fetch JSON")

        val urlHomeFeed = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(urlHomeFeed).build()

        val client = OkHttpClient()
        // in MainActivity I can't execute I have to queue it.
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                // android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
                runOnUiThread {
                    recycleView_main.adapter = MainAdapter(homeFeed)
                }


            }

            override fun onFailure(call: Call?, e: IOException?) {
                error("Failed to execute request")
            }
        })
    }


}

