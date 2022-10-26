package com.example.muthootdemo2

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun showApiError(errorString: String) {
        //showing error message
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        /*Show Progress bar here*/
    }

    fun hideProgress() {
        /*Hide Progress bar here*/
    }
}