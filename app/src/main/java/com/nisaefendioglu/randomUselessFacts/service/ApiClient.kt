package com.nisaefendioglu.randomUselessFacts.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        var BASE_URL = "https://uselessfacts.jsph.pl/"

        fun create(java: Class<ApiInterface>): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}