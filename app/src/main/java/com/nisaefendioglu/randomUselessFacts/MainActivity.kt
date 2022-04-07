package com.nisaefendioglu.randomUselessFacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nisaefendioglu.randomUselessFacts.model.RandomUseless
import com.nisaefendioglu.randomUselessFacts.service.ApiClient
import com.nisaefendioglu.randomUselessFacts.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clientRest: ApiInterface = ApiClient.create(ApiInterface::class.java)
        val callResponse: Call<RandomUseless> = clientRest.getRandom()
        callResponse.enqueue(object : Callback<RandomUseless?>{
            override fun onResponse(call: Call<RandomUseless?>, response: Response<RandomUseless?>) {
                val randomResponse: RandomUseless? = response.body()
                if (randomResponse != null) {
                    info.setText("“" +randomResponse.text + "”")
                    source.setText(randomResponse.source)
                }
            }
            override fun onFailure(call: Call<RandomUseless?>, t: Throwable) {
                Log.d("Fail", t.toString())
            }

        })

    }

}
