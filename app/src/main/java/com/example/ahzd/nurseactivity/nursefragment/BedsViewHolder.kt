package com.example.ahzd.nurseactivity.nursefragment

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R

class BedsViewHolder(itemView: View, context: Context, private val listener: OnLongClickCallback,private val listenertwo:OnItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    private val bedImage = itemView.findViewById(R.id.bedImageImageView) as ImageView
    private val bedNumber = itemView.findViewById(R.id.bedNumberTextView) as TextView
    private val ctx = context

    fun init(
        item: Int,
        isTaken: Boolean,
        image: Int,
        image2: Int,
        isClickable: Boolean
    ) {
        bedNumber.text = item.toString()
        bedImage.setImageResource(image)
        bedNumber.paint.isStrikeThruText = isTaken
        if (isTaken) {
            val layers = arrayOfNulls<Drawable>(2)
            layers[0] = ctx.getDrawable(image)
            layers[1] = ctx.getDrawable(image2)
            val layerDrawable = LayerDrawable(layers)
            bedImage.setImageDrawable(layerDrawable)
            bedImage.setPadding(25)
        }

        if (isClickable) {
            itemView.setOnClickListener {
                if (itemView.foreground != null) {
                    itemView.foreground = null
                    listenertwo.onItemClick(item)

                } else {

                    itemView.foreground = ctx.resources.getDrawable(R.drawable.frame)
                    listenertwo.onItemClick(item)
                }
            }
            itemView.setOnLongClickListener {
                Toast.makeText(ctx, "Long click detected", Toast.LENGTH_SHORT).show()
                itemView.foreground = null
                listener.addPatientToBed(item)
                return@setOnLongClickListener true
            }
        }
    }
}

