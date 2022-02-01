package com.judahben149.listfromrestapi

import com.judahben149.listfromrestapi.model.GitHubUser
import com.judahben149.listfromrestapi.model.PostItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/posts")
    fun fetchAllPosts(): Call<List<PostItem>>

    @GET("/{userName}")
    fun getUserDetails(@Path("userName") userName: String): Call<GitHubUser>
}