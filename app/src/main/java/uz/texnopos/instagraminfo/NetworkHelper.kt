package uz.texnopos.instagraminfo

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import uz.texnopos.instagraminfo.models.ModelNew
import uz.texnopos.instagraminfo.retrofit.ApiInterface

class NetworkHelper(private val apiClient: Retrofit) {

    fun getInfo(listener: NetworkListener, username: String) {
        val call = apiClient.create(ApiInterface::class.java).getInfo(username)
        call.enqueue(object : Callback<ModelNew> {
            override fun onResponse(call: Call<ModelNew>, response: Response<ModelNew>) {
                listener.onInstagramInfoResponse(response.body())
            }

            override fun onFailure(call: Call<ModelNew>, t: Throwable) {
                listener.onInstagramInfoFailure(t.localizedMessage)
            }
        })
    }
}