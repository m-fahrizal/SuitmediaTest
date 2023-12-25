package com.example.suitmediatest.data.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmediatest.data.model.UserResponse
import com.example.suitmediatest.databinding.ItemRowUsersBinding
import com.example.suitmediatest.ui.SecondScreen

class UserAdapter(private val listUser: ArrayList<UserResponse>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(var binding: ItemRowUsersBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemRowUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val (username, email, avatarUrl) = listUser[position]
        holder.binding.tvItemName.text = username.toString()
        holder.binding.tvItemEmail.text = email.toString()
        Glide.with(holder.itemView.context)
            .load(avatarUrl)
            .into(holder.binding.imgItemPhoto)

        holder.itemView.setOnClickListener {

            val intentDetail = Intent(holder.itemView.context, SecondScreen::class.java)
            intentDetail.putExtra("extra_username", username)
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}