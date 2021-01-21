package com.herbeth.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun lista(): Call<List<PostModel>>

}