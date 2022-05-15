package com.example.ahzd.nurseactivity.nursefragment

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R
import com.example.ahzd.utils.filterNotIn
import kotlin.system.measureTimeMillis

class BedsAdapter(
    context: Context,
    private val listOfBeds: List<Int>,
    private val onLongClickCallback: OnLongClickCallback,
    private val callback:OnItemClickListener
) :
    RecyclerView.Adapter<BedsViewHolder>() {

    private val initBedsTaken = mutableListOf(1, 2, 4)
    private var bedsTaken = mutableListOf(1, 2, 4)
    var positionsClickable = listOfBeds.filterNotIn(bedsTaken)
    private val startingClickable = positionsClickable

    private var ctx = context

    @SuppressLint("NotifyDataSetChanged")
    fun getAll() {
        positionsClickable = startingClickable
        notifyDataSetChanged()
    }


    fun setClickablePosition(position: Int) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bed_item, parent, false)
        return BedsViewHolder(view, ctx, onLongClickCallback,callback)
    }

    override fun onBindViewHolder(holder: BedsViewHolder, position: Int) {

        val item = listOfBeds[position]
        val isTaken = bedsTaken.any { itemTaken -> itemTaken == item }
        val isClickable = positionsClickable.any { canBeClicked -> canBeClicked == position }
        holder.init(item, isTaken, R.drawable.bed, R.drawable.red_cross, isClickable)


    }

    override fun getItemCount(): Int = listOfBeds.size
}