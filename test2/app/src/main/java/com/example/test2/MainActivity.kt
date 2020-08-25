package com.example.test2

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var users: ArrayList<UsersParsed> = arrayListOf()
    lateinit var userAdapter: UserViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        userAdapter = UserViewAdapter(users)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = userAdapter
        }
        loadUsers()
    }

    private fun loadUsers() {
        val request = UsersApiClient.buildService(UsersListInterface::class.java)
        val call = request.getUser("2")
        showProgress()
        call.enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                if (response.isSuccessful) {
                    hideProgress()
                    users = arrayListOf(response.body()!!.usersParsed)
                    userAdapter.users = users
                    userAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                hideProgress()
                showMessage(t.message!!)
            }
        })
    }

    private fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}