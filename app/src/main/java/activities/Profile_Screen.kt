package activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import com.example.twitter_yammer_duplicate.R
import kotlinx.android.synthetic.main.activity_profile__screen.*
import models.globalInformation
import java.net.URL

class Profile_Screen : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile__screen)



        username_profile.setText(globalInformation.username)
        //profilePic
        firstname_profile.setText(globalInformation.firstName)
        lastname_profile.setText(globalInformation.lastName)

        reverse_button.setOnClickListener {
            val intent = Intent(this@Profile_Screen, Main_Screen::class.java)
            startActivity(intent)
        }

        apply_button.setOnClickListener {


            globalInformation.username = username_profile.text.toString()
            globalInformation.firstName = firstname_profile.text.toString()
            globalInformation.lastName = lastname_profile.text.toString()

            val intent = Intent(this@Profile_Screen, Main_Screen::class.java)
            startActivity(intent)
        }

        profilePic.setOnClickListener{
            val callCameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callCameraIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(callCameraIntent, CAMERA_REQUEST_CODE)
            }
        }




    }


    companion object {
        fun newIntent(context: Context) = Intent(context, Profile_Screen::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    profilePic.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            }
            else -> {
                Toast.makeText(this, "Unrecognized request code", Toast.LENGTH_SHORT)
            }
        }
    }




}