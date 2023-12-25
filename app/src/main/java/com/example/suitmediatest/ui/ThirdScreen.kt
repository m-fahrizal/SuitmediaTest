package com.example.suitmediatest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitmediatest.data.adapter.UserAdapter
import com.example.suitmediatest.data.api.ApiConfig
import com.example.suitmediatest.data.model.UserResponse
import com.example.suitmediatest.databinding.ActivityThirdScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreen : AppCompatActivity() {
    private val list = ArrayList<UserResponse>()
    private lateinit var binding: ActivityThirdScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = binding.rvUser

        user.setHasFixedSize(true)
        user.layoutManager = LinearLayoutManager(this)

        ApiConfig.apiService.getUser().enqueue(object: Callback<ArrayList<UserResponse>>{
            override fun onResponse(
                call: Call<ArrayList<UserResponse>>,
                response: Response<ArrayList<UserResponse>>
            ) {
                val responseCode = response.code().toString()
                response.body()?.let { list.addAll(it) }
                val adapter = UserAdapter(list)
                user.adapter = adapter

            }

            override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {

            }

        })
    }
}