package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.twitter_yammer_duplicate.R
import com.example.twitter_yammer_duplicate.RetroFitClient
import kotlinx.android.synthetic.main.activity_new__user.*
import models.TokenModel
import models.globalInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class New_User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new__user)

        cancelButton.setOnClickListener {
            val intent = Intent(this@New_User,Login_Page::class.java)
            startActivity(intent)
        }

        createButton.setOnClickListener {
            val username = username.text.toString().trim()
            val password = password.text.toString().trim()
            val firstname = firstname.text.toString().trim()
            val lastname = lastname.text.toString().trim()
            var tokenStuff = globalInformation()

            val intent = Intent(this,Main_Screen::class.java)

            RetroFitClient.instance.createUser( username, password, firstname, lastname)
                .enqueue(object : Callback<TokenModel>{
                    override fun onFailure(call: Call<TokenModel>, t: Throwable) {
                        Toast.makeText(applicationContext,t.localizedMessage,Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<TokenModel>,
                        response: Response<TokenModel>
                    ) {

                        Toast.makeText(applicationContext, "Successfully logged in" + response.body()?.token,Toast.LENGTH_LONG).show()
                        globalInformation.token_Authorization = (response.body()?.token).toString()
                        globalInformation.username = username
                        globalInformation.firstName = firstname
                        globalInformation.lastName = lastname

                    }


                })


            startActivity(intent)
        }


        }
    }
