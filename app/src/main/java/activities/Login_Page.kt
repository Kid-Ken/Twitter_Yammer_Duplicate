package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.twitter_yammer_duplicate.R
import com.example.twitter_yammer_duplicate.RetroFitClient
import kotlinx.android.synthetic.main.activity_main.*
import models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import models.globalInformation

class Login_Page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Do not need to find your view by ID anymore just use the ID and whatever you want to do.



        login_button.setOnClickListener {

            val username = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()


            RetroFitClient.instance.serverLogin(username, password)
                .enqueue(object : Callback<TokenModel>{
                    override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                        Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<TokenModel>,
                        response: Response<TokenModel>
                    ) {

                        Toast.makeText(applicationContext, "Successfully logged in" + response.body()?.token,Toast.LENGTH_LONG).show()
                        Log.d("Funnier",(response.body()?.token).toString())

                        globalInformation.token_Authorization = (response.body()?.token).toString()

                        val intent = Intent(this@Login_Page,Main_Screen::class.java)
                        startActivity(intent)
                    }


                })
        }
        newUser.setOnClickListener {

        val intent = Intent(this@Login_Page,New_User::class.java)
            startActivity(intent)

        }
    }
}