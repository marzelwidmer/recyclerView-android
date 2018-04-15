package ch.keepcalm.recyclerview_android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomerViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomerViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val video = homeFeed.videos.get(position)
        holder.view.textView_video_title.text = video.name
        holder.view.textView_channel_name.text = video.channel.name

        Picasso.get().load(video.imageUrl).into(holder.view.imageView_video_thumbnail)
        Picasso.get().load(video.channel.profileImageUrl).into(holder.view.imageView_channel_profile)

    }


}

class CustomerViewHolder(val view: View) : RecyclerView.ViewHolder(view)