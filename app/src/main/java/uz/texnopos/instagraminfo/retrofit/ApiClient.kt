package uz.texnopos.instagraminfo.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private lateinit var retrofit: Retrofit
        private lateinit var gson: Gson

        fun getClient(): Retrofit {
            if (!::gson.isInitialized) {
                gson = GsonBuilder()
                    .setLenient()
                    .create()
            }

            if (!::retrofit.isInitialized) {
                val okHttpClient = OkHttpClient.Builder().apply {
                    addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            builder.header("x-rapidapi-key", "176e4091b0msh71756890daac2fcp148d02jsn75facf387c45")
                            builder.header("x-rapidapi-host", "instagram40.p.rapidapi.com")
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                }.build()

                retrofit = Retrofit.Builder()
                    .baseUrl("https://instagram40.p.rapidapi.com/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit
        }
    }
}