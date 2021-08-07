package com.nchikvinidze.messengerapp.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nchikvinidze.messengerapp.R
import com.nchikvinidze.messengerapp.data.User

class SearchAdapter(var model: List<User>) : RecyclerView.Adapter<UserItemViewHolder>() {
    var clickListener: ClickListener? = null

    override fun getItemCount(): Int {
        return model.size
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val item = model[position]
        holder.clickListener = clickListener
        holder.fill(item)
    }

    fun update(model: List<User>) {
        this.model = model
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))
    }

}

interface ClickListener {
    fun onClicked(user: User)
}