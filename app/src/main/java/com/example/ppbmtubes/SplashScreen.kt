package com.example.ppbmtubes

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val videoView : VideoView = findViewById<VideoView>(R.id.videoViewSplash)
        val videoPath : String ="android.resource://"+ packageName + "/" +R.raw.splscreen

        val videoUri : Uri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)
        videoView.start()

        videoView.setOnCompletionListener {

            val intent = Intent(this, LoginSignup::class.java)
            startActivity(intent)
            finish()
        }
    }
}