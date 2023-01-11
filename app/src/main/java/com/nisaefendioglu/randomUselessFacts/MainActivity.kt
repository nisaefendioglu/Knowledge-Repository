package com.nisaefendioglu.randomUselessFacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
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

        getCallApi()

        swipeRefreshLayout.setOnRefreshListener {
            getCallApi()
            swipeRefreshLayout.isRefreshing = false
        }

    }

    private fun getCallApi() {
        val clientRest: ApiInterface = ApiClient.create(ApiInterface::class.java)
        val callResponse: Call<RandomUseless> = clientRest.getRandom()
        callResponse.enqueue(object : Callback<RandomUseless?> {
            override fun onResponse(
                call: Call<RandomUseless?>,
                response: Response<RandomUseless?>
            ) {
                progressBar.visibility = View.INVISIBLE
                info.visibility = View.VISIBLE
                val randomResponse: RandomUseless? = response.body()
                if (randomResponse != null) {
                    info.text = "“" + randomResponse.text + "”"
                }
            }

            override fun onFailure(call: Call<RandomUseless?>, t: Throwable) {
                info.text = "Please check your internet connection."
            }

        })
    }

}
