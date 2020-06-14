package com.example.twitter_yammer_duplicate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email_content = findViewById<TextView>(R.id.editTextTextEmailAddress)
        val password_conetent = findViewById<TextView>(R.id.editTextTextPassword)






        val login_button = findViewById<Button>(R.id.login_button)




        //login_button?.setOnLongClickListener()
        //{
            //Toast.makeText( applicationContext,
                //$login_message,
            //Toast.LENGTH_LONG).show())             */
        //}



        fun IsEmailValid(email: String):Boolean {
            TODO("Add in the proper way to validate the email.")
            return false;
        }


        fun isPasswordValid(password: String ): Boolean{
            return password.length > 5;
        }

    }
}