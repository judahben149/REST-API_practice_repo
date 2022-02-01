package com.judahben149.listfromrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.listfromrestapi.databinding.ActivityMainBinding
import com.judahben149.listfromrestapi.model.PostItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var rvList: RecyclerView
    private lateinit var myAdapter: ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val post: List<PostItem>


//        rvList = binding.rvList
//
//        rvList.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//        }

//        retrofitAndApiStuff()

        binding
        fetchGitHubUserDetails()
    }

    private fun fetchGitHubUserDetails(userName: String) {
        val retrofitGitHubAPI = Retrofit.Builder()
            .baseUrl("https://api.github.com/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofitGitHubAPI.getUserDetails(userName)
    }

//    private fun retrofitAndApiStuff() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val api = retrofit.create(ApiService::class.java)
//
//        api.fetchAllPosts().enqueue(object: Callback<List<PostItem>>{
//            override fun onResponse(call: Call<List<PostItem>>, response: Response<List<PostItem>>) {
//                val responseBody = response.body()!!
//
//                myAdapter = ListAdapter(baseContext, responseBody)
//                myAdapter.notifyDataSetChanged()
//                rvList.adapter = myAdapter
//
//
//            }
//
//            override fun onFailure(call: Call<List<PostItem>>, t: Throwable) {
//                Log.d("judahActivity", "onFailure")
//            }
//
//        })
//    }
}