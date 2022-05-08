package com.example.ahzd.nurseactivity.nursefragment

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R

class BedsViewHolder(itemView: View, context: Context,val listener: OnLongClickCallback) : RecyclerView.ViewHolder(itemView) {

    private val bedImage = itemView.findViewById(R.id.bedImageImageView) as ImageView
    private val bedNumber = itemView.findViewById(R.id.bedNumberTextView) as TextView
    private val ctx = context
    //val listener = listener

    fun init(
        item: Int,
        isTaken: Boolean,
        image: Int,
        isClickable: Boolean
    ) {
        bedNumber.text = item.toString()
        bedImage.setImageResource(image)
        bedNumber.paint.isStrikeThruText = isTaken
        if (isClickable) {
            itemView.setOnClickListener {
                if (itemView.foreground != null ){
                    Log.d("Test","I am in if")
                    itemView.foreground = null
                }else {
                    itemView.foreground = ctx.resources.getDrawable(R.drawable.frame)
                }
            }
            itemView.setOnLongClickListener {
                Toast.makeText(ctx, "Long click detected", Toast.LENGTH_SHORT).show()
                itemView.foreground = null
                listener.addPatientToBed()
                return@setOnLongClickListener true
            }
        }
    }
}

