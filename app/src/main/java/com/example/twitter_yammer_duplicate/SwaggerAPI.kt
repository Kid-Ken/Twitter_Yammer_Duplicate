package com.example.twitter_yammer_duplicate

import retrofit2.Call
import retrofit2.http.*

interface SwaggerAPI {

    @FormUrlEncoded
    @POST("serverLogin")
    fun serverLogin(
        @Field("username") username:String,
        @Field("password") password:String
    ):Call<TokenModel>

    @FormUrlEncoded
    @POST("createUser")
    fun createUser(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("firstname") firstname: String,
        @Field("lastname") lastname: String
    ):Call<UserInformationModel>

    @PUT("accountLogout")
    fun accountLogout(){

    }

    @GET("getUser")
    fun getUser(){

    }

    @FormUrlEncoded
    @POST("userPicture")
    fun userPicture(){

    }

    @GET("getUserUsername")
    fun getUserUsername(){

    }

    @GET("getFeed")
    fun accountLgetFeedogout(){

    }

    @FormUrlEncoded
    @POST("createPost")
    fun createPost(){

    }

    @PUT("updatePost")
    fun updatePost(){

    }

    @FormUrlEncoded
    @POST("createComment")
    fun createComment(){

    }

    @PUT("updateComment")
    fun updateComment(){

    }
}