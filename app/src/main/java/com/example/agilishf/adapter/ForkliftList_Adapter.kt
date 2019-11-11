package com.example.agilishf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.progresviews.ProgressLine
import com.example.agilishf.R

class ForkliftList_Adapter(val forkliftList: ArrayList<Int>): RecyclerView.Adapter<ForkliftList_Adapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.progressLine?.setmValueText("Forklift${position}: ${forkliftList[position]}")
        holder?.progressLine?.setmPercentage(forkliftList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.forklift_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return forkliftList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val progressLine = itemView.findViewById<ProgressLine>(R.id.forklift_progressLine)
    }

}