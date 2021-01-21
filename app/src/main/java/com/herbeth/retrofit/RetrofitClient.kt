package com.herbeth.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/*
Instancia uma unica conexao - Singleton
 */
class RetrofitClient private constructor() {

    companion object {

        private lateinit var retrofit: Retrofit
        private val baseUrl = "https://jsonplaceholder.typicode.com/"

        private fun getRetrofitInstance(): Retrofit {

            val httpClient = OkHttpClient.Builder()
            if(!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .client(httpClient.build()) // TODO garencia as conexoes http
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return retrofit

        }

        fun <T> createService(serviceClass: Class<T>): T {
            return getRetrofitInstance().create(serviceClass)
        }
    }

}