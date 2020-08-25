package com.example.test2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user.view.*

class UserViewAdapter(var users: List<UsersParsed>): RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position])
    }
}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val avatar:ImageView = itemView.avatar
    private val name:TextView = itemView.userName
    private val email:TextView = itemView.userEmail


    fun bind(user: UsersParsed) {
        Glide.with(itemView.context).load("${user.avatar}").into(avatar)
        name.text = user.firstName + user.lastName
        email.text = user.email

    }

}
