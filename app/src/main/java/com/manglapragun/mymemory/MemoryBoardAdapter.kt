package com.manglapragun.mymemory

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object{
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {  // how to create 1 view of our recycler view
        val cardWidth = parent.width/2 - (2* MARGIN_SIZE)
        val cardHeight = parent.height/4 - (2* MARGIN_SIZE)
        val cardSideLength = min(cardHeight,cardWidth)
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)
        val layoutParams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = numPieces

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val ImageButton = itemView.findViewById<ImageButton>(R.id.imageButton)

            fun bind(position: Int) {
                ImageButton.setOnClickListener {
                    Log.i(TAG, "Clicked on position $position")
                }
            }
        }

}
