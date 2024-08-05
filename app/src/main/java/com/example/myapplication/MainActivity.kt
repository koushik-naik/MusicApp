package com.example.myapplication

import ApiService
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var  musicrecyclerview :RecyclerView
lateinit var musicadapter :    MusicAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


musicrecyclerview =findViewById(R.id.recyclerview)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        val data = apiService.getData("eminem")

        data.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                val datalist =response.body()?.data!!
           musicadapter =MusicAdapter(this@MainActivity, datalist )
                musicrecyclerview.adapter = musicadapter
                musicrecyclerview.layoutManager=LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
              Log.d("failed","failed")
            }
        })
    }
}
