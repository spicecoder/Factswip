package io.pronab.factswip.network
import io.pronab.factswip.model.Facts
import retrofit2.Call
import retrofit2.http.GET

interface Facts_Api {

    @get:GET("all")
    val facts: Call<Facts>

    companion object {

        val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json/"

    }
}
