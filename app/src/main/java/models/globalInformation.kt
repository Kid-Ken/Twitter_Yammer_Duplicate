package models

import android.app.Application

//holds the token value
class globalInformation() : Application() {
    companion object {
        var token_Authorization = " "
        var username = " "
        var firstName = " "
        var lastName = " "
        var profilePic = " "

    }
}