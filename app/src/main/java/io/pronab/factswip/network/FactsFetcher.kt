package io.pronab.factswip.network

import android.arch.lifecycle.MutableLiveData
import io.pronab.factswip.Factswip
import io.pronab.factswip.model.Facts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactsFetcher(private var factsRepo: MutableLiveData<Facts>? = MutableLiveData()) {
    fun loadFacts(): MutableLiveData<Facts>? {

        val retrofit = Retrofit.Builder()
            .baseUrl(FactsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val factsApi: FactsApi = retrofit.create<FactsApi>(FactsApi::class.java)
        val call = factsApi.facts


        call.enqueue(object : Callback<Facts> {
            override fun onResponse(call: Call<Facts>, response: Response<Facts>) {

                //finally we are setting the list to our MutableLiveData
                this@FactsFetcher.factsRepo!!.value = response.body()
            }

            override fun onFailure(call: Call<Facts>, t: Throwable) {
                this@FactsFetcher.factsRepo!!.value = Facts(Factswip.FETCH_ERROR)

            }
        })
        return factsRepo as MutableLiveData<Facts>
    }
}