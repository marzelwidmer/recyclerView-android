package ch.keepcalm.recyclerview_android

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdapter : RecyclerView.Adapter<CustomerViewHolder>() {

    // number of items
    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomerViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
    }



}

class CustomerViewHolder(v: View): RecyclerView.ViewHolder(v)