package com.judahben149.listfromrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.judahben149.listfromrestapi.databinding.ActivityMainBinding
import com.judahben149.listfromrestapi.model.GitHubUser
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchGitHubUserDetails()
    }

    private fun fetchGitHubUserDetails() {
        val retrofitGitHubAPI = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        binding.btnFetchUserDetails.setOnClickListener {
            val userName = binding.etEnterUserName.text.toString()
            Snackbar.make(
                binding.root,
                userName,
                Snackbar.LENGTH_LONG
            ).show()

            retrofitGitHubAPI.getUserDetails(userName).enqueue(object : Callback<GitHubUser> {
                override fun onResponse(call: Call<GitHubUser>, response: Response<GitHubUser>) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Log.d("MainActivity", responseBody.followers.toString())
                    }
                    Snackbar.make(
                        binding.root,
                        responseBody?.login.toString(),
                        Snackbar.LENGTH_LONG
                    ).show()


                    binding.tvUserFullName.text = responseBody?.name
                    binding.tvUserName.text = responseBody?.login
                    binding.tvUserLocation.text = responseBody?.location
                }

                override fun onFailure(call: Call<GitHubUser?>, t: Throwable) {
                    Snackbar.make(
                        binding.root,
                        "Error fetching details - " + t.message,
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            })
        }
    }
}
