package activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.twitter_yammer_duplicate.R
import kotlin.coroutines.coroutineContext

class Create_Tweet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create__tweet)

        if(intent.hasExtra(PARAM_USER_ID) && intent.hasExtra(PARAM_USER_NAME)) {
            //userId = intent.getStringExtra(PARAM_USER_ID)
            //userName = intent.getStringExtra(PARAM_USER_NAME)
        } else {
            Toast.makeText(this, "Error creating tweet", Toast.LENGTH_SHORT).show()
            finish()
        }
    }



    fun addImage(v: View) {

    }

    fun postTweet(v: View) {

    }


    companion object {
        val PARAM_USER_ID = "UserId"
        val PARAM_USER_NAME = "UserName"

        fun newIntent(context: Context, userId: String?, userName: String?): Intent {
            val intent = Intent(context, Create_Tweet::class.java)
            intent.putExtra(PARAM_USER_ID, userId)
            intent.putExtra(PARAM_USER_NAME, userName)
            return intent
        }

    }
}