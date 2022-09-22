package com.example.movieclub.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.movieclub.R
import java.lang.Thread.sleep

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }, 3000)

        /*  val thread = Thread {
        @Override
         fun run(){
            try {
                sleep(2000)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            catch (e:InterruptedException ) {
                e.printStackTrace()
            }}}
    thread.start()
        }*/
    }
    }
