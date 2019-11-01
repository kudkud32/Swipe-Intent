package id.rackspira.swipeintent.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import id.rackspira.swipeintent.R
import id.rackspira.swipeintent.util.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_media_player)

        this.overridePendingTransition(
            R.anim.anim_slide_in_bottom,
            R.anim.anim_slide_out_bottom
        )

        val srcVideo = Uri.parse("https://storage.coverr.co/videos/coverr-soap-bubbles-outdoor-1567244523991?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBJZCI6IjExNDMyN0NEOTRCMUFCMTFERTE3IiwiaWF0IjoxNTcyNTM0NzY1fQ.mw0uxfdpGvy0SNfsJd2YRJHJ2xMmEMxB_06BVGCsOLM")
        launcherVideo.setVideoURI(srcVideo)

        launcherVideo.setOnPreparedListener {
            it.setVolume(0F, 0F)
            it.isLooping = true
        }

        launcherVideo.start()

        constraintLayoutMediaPlayer.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
            }

            override fun onSwipeRight() {
            }

            override fun onSwipeTop() {
            }

            override fun onSwipeBottom() {
                val intent = Intent(applicationContext, DetailContentActivity::class.java)
                intent.putExtra("StatusFrom", "MediaPlayer")
                startActivity(intent)
            }
        })
    }
}
