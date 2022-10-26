package com.example.data.network

import com.example.data.networkClient.NetworkService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkHelper {

    private val gson = GsonBuilder().setLenient().create()
    private val timeOut: Long = 120

    fun getRetrofitObject(): NetworkService {
        val retrofit = getRetrofit()
        return retrofit.create(NetworkService::class.java)
    }

    fun getRetrofit() = Retrofit.Builder()
        .baseUrl(AllApi.BASE_URL_STG)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(getOkHttp())
        .build()

    private fun getOkHttp(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(getLoggingInterceptor())
            .addInterceptor { chain ->
                val resp = chain.proceed(chain.request())
                if (resp.code == 200) {
                    try {
                        val myJson = resp.peekBody(2048).string()
                        //println(myJson)
                    } catch (e: Exception) {
                        println("Error parse json from intercept..............")
                    }
                } else {
                    //println(resp)
                }
                resp
            }

            .build()
        return okHttpClient
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }
}