package io.pronab.factswip.network

import android.arch.lifecycle.MutableLiveData
import io.pronab.factswip.Factswip
import io.pronab.factswip.model.Facts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactsFetcher() {
    private var factsRepo: MutableLiveData<Facts>? = MutableLiveData<Facts>()
    fun loadFacts(): MutableLiveData<Facts>? {

        val retrofit = Retrofit.Builder()
            .baseUrl(Facts_Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val facts_api: Facts_Api = retrofit.create<Facts_Api>(Facts_Api::class.java)
        val call = facts_api.facts


        call.enqueue(object : Callback<Facts> {
            override fun onResponse(call: Call<Facts>, response: Response<Facts>) {

                //finally we are setting the list to our MutableLiveData
                factsRepo!!.setValue(response.body())
            }

            override fun onFailure(call: Call<Facts>, t: Throwable) {
                factsRepo!!.setValue(Facts(Factswip.FETCH_ERROR))

            }
        })
        return factsRepo as MutableLiveData<Facts>
    }
}