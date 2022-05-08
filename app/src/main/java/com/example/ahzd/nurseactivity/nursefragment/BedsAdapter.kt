package com.example.ahzd.nurseactivity.nursefragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R
import com.example.ahzd.utils.filterNotIn

class BedsAdapter(
    context: Context,
    private val listofNumbers: List<Int>,
    private val listener: OnItemClickListener,
    private val listener_second :OnLongClickCallback
) :
    RecyclerView.Adapter<BedsViewHolder>() {
    private val apiResponse = mutableListOf(1, 2, 4)
     var positionsClickable = listofNumbers.filterNotIn(apiResponse)
    private val startingClickable = positionsClickable

    private var ctx = context

    fun getAll() {
        positionsClickable = startingClickable
        //Log.d("Refresh",positionsClickable.toString())
        notifyDataSetChanged()
    }


    fun setClickablePosition(position: Int): Int {
        val mutableList = positionsClickable.toMutableList()
        mutableList.clear()
        mutableList.add(position)
        this.positionsClickable = mutableList
        notifyDataSetChanged()
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bed_item, parent, false)
        return BedsViewHolder(view,ctx,listener_second)
    }

    override fun onBindViewHolder(holder: BedsViewHolder, position: Int) {

        val item = listofNumbers[position]
        val isTaken = apiResponse.any { itemTaken -> itemTaken == item }
        val isClickable = positionsClickable.any { canBeClicked -> canBeClicked == position }
        holder.init(item, isTaken, R.drawable.bed,isClickable)

        Log.d("TestClickable", isClickable.toString())
        Log.d("TestPosition", position.toString())


    }

    override fun getItemCount(): Int = listofNumbers.size
}