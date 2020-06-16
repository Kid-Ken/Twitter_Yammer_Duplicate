package com.example.twitter_yammer_duplicate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Do not need to find your view by ID anymore just use the ID and whatever you want to do.
        login_button.setOnClickListener {

            val username = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()

            RetroFitClient.instance.serverLogin( username, password )
                .enqueue(object : Callback<TokenModel>{
                    override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                        Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<TokenModel>,
                        response: Response<TokenModel>
                    ) {
                        Toast.makeText(applicationContext, response.body()?.token,Toast.LENGTH_LONG).show()
                    }


                })
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }








    fun IsEmailValid(email: String):Boolean {
        TODO("Add in the proper way to validate the email.")
        return false
    }


    fun isPasswordValid(password: String ): Boolean{
        return password.length > 5
    }


    fun login(){
    }




}