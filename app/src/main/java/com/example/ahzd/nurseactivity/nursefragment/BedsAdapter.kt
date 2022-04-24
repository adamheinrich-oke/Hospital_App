package com.example.ahzd.nurseactivity.nursefragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ahzd.R
import com.google.android.gms.common.api.Api

class BedsAdapter(private val listofNumbers: List<String>, private val image: Int) :
    RecyclerView.Adapter<BedsAdapter.BedsViewHolder>() {

    val ApiResponse = arrayListOf("1","2","4")

     class BedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val bedImage = itemView.findViewById(R.id.bedImageImageView) as ImageView
        val bedNumber = itemView.findViewById(R.id.bedNumberTextView) as TextView


       fun  init (item:String,isTaken:Boolean,image:Int){

            itemView.setOnClickListener {
                val  position = bindingAdapterPosition + 1
                Toast.makeText(itemView.context,"Item clicked on position -> $position",Toast.LENGTH_SHORT).show()
            }

           bedNumber.text = item
           bedImage.setImageResource(image)
           bedNumber.paint.isStrikeThruText = isTaken
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bed_item, parent, false)
        return BedsViewHolder(view)
    }

    override fun onBindViewHolder(holder: BedsViewHolder, position: Int) {

        val item = listofNumbers[position]
        val isTaken = ApiResponse.any { itemTaken -> itemTaken == item }
        holder.init(item,isTaken,R.drawable.beddd)

    }

    override fun getItemCount(): Int = listofNumbers.size
}