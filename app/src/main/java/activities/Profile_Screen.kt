package activities

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.twitter_yammer_duplicate.R
import kotlinx.android.synthetic.main.activity_profile__screen.*
import models.globalInformation
import java.net.URL

class Profile_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile__screen)



        username_profile.setText(globalInformation.username)
        //profilePic
        firstname_profile.setText(globalInformation.firstName)
        lastname_profile.setText(globalInformation.lastName)

        Log.d("username", globalInformation.username)
        Log.d("firstName", globalInformation.firstName)
        Log.d("lastName", globalInformation.lastName)


        reverse_button.setOnClickListener {
            val intent = Intent(this@Profile_Screen,Main_Screen::class.java)
            startActivity(intent)
        }

        apply_button.setOnClickListener {


            globalInformation.username = username_profile.text.toString()
            globalInformation.firstName = firstname_profile.text.toString()
            globalInformation.lastName = lastname_profile.text.toString()

            val intent = Intent(this@Profile_Screen,Main_Screen::class.java)
            startActivity(intent)
        }

    }
}