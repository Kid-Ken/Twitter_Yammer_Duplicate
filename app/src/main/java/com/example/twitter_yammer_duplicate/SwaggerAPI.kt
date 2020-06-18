package com.example.twitter_yammer_duplicate

import models.SpecificUserModel
import models.TokenModel
import models.UserInformationModel
import retrofit2.Call
import retrofit2.http.*

interface SwaggerAPI {

    @FormUrlEncoded
    @POST("/account/login")
    fun serverLogin(
        @Field("username") username:String,
        @Field("password") password:String
    ):Call<TokenModel>

    @FormUrlEncoded
    @POST("/account/create")
    fun createUser(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("firstname") firstname: String,
        @Field("lastname") lastname: String
    ):Call<TokenModel>

    @PUT("/account/logout")
    fun accountLogout(

    ):Call<TokenModel>

    @GET("/user/")
    fun getUser(

    ):Call<SpecificUserModel>


    @FormUrlEncoded
    @POST("/user/picture")
    fun userPicture(){

    }

    @GET("/user/{username}")
    fun getUserUsername(
        @Field("username") username: String

    ):Call<SpecificUserModel>


    @GET("/feed/")
    fun accountLgetFeedogout(){

    }

    @FormUrlEncoded
    @POST("/feed/post/")
    fun createPost(){

    }

    @PUT("/feed/post")
    fun updatePost(){

    }

    @FormUrlEncoded
    @POST("/feed/:postId/comment")
    fun createComment(){

    }

    @PUT("/feed/:postId/comment")
    fun updateComment(){

    }
}
