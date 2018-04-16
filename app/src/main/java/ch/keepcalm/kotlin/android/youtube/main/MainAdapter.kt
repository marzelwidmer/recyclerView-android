package ch.keepcalm.kotlin.android.youtube.main

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.keepcalm.kotlin.android.youtube.detail.CourseDetailActivity
import ch.keepcalm.recyclerview_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomerViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomerViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.view.textView_video_title.text = video.name
        holder.view.textView_channel_name.text =  "${video.channel.name} • ${video.numberOfViews} Views \n${video.channel.numberOfSubscribers} Channel subscribers"

        Picasso.get().load(video.imageUrl).into(holder.view.imageView_video_thumbnail)
        Picasso.get().load(video.channel.profileImageUrl).into(holder.view.imageView_channel_profile)

        holder.video = video

    }


}

class CustomerViewHolder(val view: View, var video: Video? = null) : RecyclerView.ViewHolder(view){

    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }
    init{
        view.setOnClickListener{
            val intent = Intent(view.context, CourseDetailActivity::class.java)

            // change nav bar title
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id.toString())

            view.context.startActivity(intent)

        }
    }
}