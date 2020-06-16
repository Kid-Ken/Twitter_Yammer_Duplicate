package com.example.twitter_yammer_duplicate

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient {

    private val authorizationToken = "-M9ywHhgUCumz9dDi6LT"


    private const val BASE_URL = "us-central1-bluefletch-learning-assignment.cloudfunctions.net/"
    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor {chain ->
                val original = chain.request()

                val requestBuilder = original.newBuilder()
                    .addHeader("Authorization", authorizationToken)
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