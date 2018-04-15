package ch.keepcalm.recyclerview_android.homefeed

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

class HomeFeedClient {

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

            }

            override fun onFailure(call: Call?, e: IOException?) {
                error("Failed to execute request")
            }
        })
    }

}

