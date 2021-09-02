package com.example.keyboardinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListKeyboardAdapter(private val listKeyboard: ArrayList<Keyboard>) :
    RecyclerView.Adapter<ListKeyboardAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.name_item_keyboard)
        var tvSubtitle: TextView = itemView.findViewById(R.id.subtitle_item_keyboard)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Keyboard, index: Int)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListKeyboardAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_keyboard, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListKeyboardAdapter.ListViewHolder, position: Int) {
        val keyboard = listKeyboard[position]

        Glide.with(holder.itemView.context)
            .load(keyboard.photoUrl)
            .into(holder.imgPhoto)

        holder.tvName.text = keyboard.name
        holder.tvSubtitle.text = keyboard.subTitle

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listKeyboard[holder.adapterPosition],
                position
            )
        }
    }

    override fun getItemCount(): Int {
        return listKeyboard.size
    }


}