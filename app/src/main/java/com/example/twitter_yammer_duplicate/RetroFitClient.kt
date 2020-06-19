package com.example.twitter_yammer_duplicate

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import models.globalInformation
import java.util.concurrent.TimeUnit
import models.globalInformation.Companion.token_Authorization

object RetroFitClient {


    private const val BASE_URL =
        "https://us-central1-bluefletch-learning-assignment.cloudfunctions.net/"

    private val okHttpClient = OkHttpClient.Builder().apply {
        readTimeout(20, TimeUnit.SECONDS)
        writeTimeout(20, TimeUnit.SECONDS)
        connectTimeout(20, TimeUnit.SECONDS)
    }
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", token_Authorization)
                .method(original.method, original.body)

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: SwaggerAPI by lazy {
        val retroFit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)

            .build()

        retroFit.create(SwaggerAPI::class.java)
    }
}