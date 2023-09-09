package com.example.widgetpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.widgetpractice.data.RecyclerData
import com.example.widgetpractice.databinding.ListitemRecyclerviewBinding

class RecyclerAdapter(
    private val items: List<RecyclerData>,
    private val listener: AdapterListener
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(ListitemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * 정상코드
     * */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, position, listener)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val view: ListitemRecyclerviewBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(item: RecyclerData, index: Int, listener: AdapterListener){

//            view.noText.text = "NO"
//            view.nameText.text = "Name"
//            view.tickerText.text = "Ticker"
//            view.closeText.text = "Price"
//            view.highText.text = "High"
//            view.lowText.text = "Low"
//            view.volumeText.text = "Volume"

            view.noText.text = "${index + 1}"
            view.nameText.text = item.name
            view.tickerText.text = item.ticker
            view.closeText.text = "${item.price}"
            view.highText.text = "${item.high}"
            view.lowText.text = "${item.low}"
            view.volumeText.text = "${item.volume}"
        }
    }

}