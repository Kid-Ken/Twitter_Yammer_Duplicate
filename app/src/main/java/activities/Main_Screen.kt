package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.twitter_yammer_duplicate.R
import com.example.twitter_yammer_duplicate.RetroFitClient
import kotlinx.android.synthetic.main.activity_main__screen.*
import models.SpecificUserModel
import models.UserInformationModel
import models.globalInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Main_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__screen)

        logout_Button.setOnClickListener {
           RetroFitClient.instance.accountLogout()
            val intent = Intent(this@Main_Screen,Login_Page::class.java)
            startActivity(intent)
        }

        profile_Button.setOnClickListener {
            RetroFitClient.instance.getUser()
                .enqueue(object : Callback<SpecificUserModel>{
                    override fun onFailure(call: Call<SpecificUserModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<SpecificUserModel>,
                        response: Response<SpecificUserModel>
                    ) {
                        globalInformation.username = (response.body()?.username).toString()
                        globalInformation.profilePic = (response.body()?.profilePic).toString()
                        globalInformation.firstName = (response.body()?.firstName).toString()
                        globalInformation.lastName = (response.body()?.lastName).toString()
                        val intent = Intent(this@Main_Screen, Profile_Screen::class.java)
                        startActivity(intent)
                    }

                })


        }

        searchbar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                RetroFitClient.instance.getUserUsername(p0)
                    .enqueue(object : Callback<SpecificUserModel>{
                        override fun onFailure(call: Call<SpecificUserModel>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                        override fun onResponse(
                            call: Call<SpecificUserModel>,
                            response: Response<SpecificUserModel>
                        ) {
                            val intent = Intent(this@Main_Screen,Profile_Screen::class.java)
                            startActivity(intent)
                        }

                    })
                return false
                }

            override fun onQueryTextChange(p0: String?): Boolean {
                TODO("Not yet implemented")
                return false

            }


        })

    }
}
