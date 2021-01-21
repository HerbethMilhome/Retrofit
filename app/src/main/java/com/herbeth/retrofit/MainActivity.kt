package com.herbeth.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val remote = RetrofitClient.createService(PostService::class.java)
        val call: Call<List<PostModel>> = remote.lista()

        val response = call.enqueue(object : Callback<List<PostModel>>{
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val json = response.body() // TODO aqui voce recebe as informações do json, agora é só manipular.
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val m = t.message
            }

        })

    }
}