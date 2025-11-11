package com.example.konekin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.konekin.databinding.ActivityDetailUsersBinding
import com.example.konekin.model.Users
import com.example.konekin.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getDetailUsers(id: Int) {
        val client = ApiClient.getInstance()
        val response = client.getDetailUsers(id)
        response.enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                // TODO: Implement response handling
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@DetailUsersActivity, "Koneksi error", Toast.LENGTH_LONG).show()
            }
        })
    }
}