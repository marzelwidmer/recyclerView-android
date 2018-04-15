package ch.keepcalm.recyclerview_android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_row.view.*
import ch.keepcalm.recyclerview_android.homefeed.HomeFeed

class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomerViewHolder>() {

//    val videoTitles = arrayListOf("1st Title" , "2nd Title", "3rd Title", "4th Title", "5th title", "6th Title")

    // number of items
    override fun getItemCount(): Int {
//        return videoTitles.size
        return homeFeed.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomerViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
//        holder.view.textView_video_title.text = videoTitles.get(position)
        holder.view.textView_video_title.text = homeFeed.videos.get(position).name

    }


}

class CustomerViewHolder(val view: View) : RecyclerView.ViewHolder(view)