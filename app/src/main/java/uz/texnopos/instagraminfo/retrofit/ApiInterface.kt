package uz.texnopos.instagraminfo.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.texnopos.instagraminfo.models.ModelNew

interface ApiInterface {
    @GET("/account-info?")
    fun getInfo(@Query("username") username: String) : Call<ModelNew>
}