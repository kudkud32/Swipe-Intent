package id.rackspira.swipeintent.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import id.rackspira.swipeintent.R
import id.rackspira.swipeintent.util.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_detail_content.*

class DetailContentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_content)

        if (intent.hasExtra("StatusFrom")) {
            val statusFrom = intent.getStringExtra("StatusFrom")

            if (statusFrom == "Adapter") {
                this.overridePendingTransition(
                    R.anim.anim_slide_in_left,
                    R.anim.anim_slide_out_left
                )
            } else if (statusFrom == "MediaPlayer") {
                this.overridePendingTransition(
                    R.anim.anim_slide_in_top,
                    R.anim.anim_slide_out_top
                )
            }
        }

        val metrics = resources.displayMetrics
        val width = metrics.widthPixels
        val height = width / 2.7

        Picasso.get().load("https://akibento.com/blog/wp-content/uploads/external/yup2ImwuPj9q4vsfDmChXkuPXx02wJK5.png").resize(width, height.toInt()).into(ivDetailContent)
        tvDetailTitleContent.text = "Shigatsu wa Kimi no Uso"
        tvDetailDescriptionContent.text = "A piano prodigy who lost his ability to play after suffering a traumatic event in his childhood is forced back into the spotlight by an eccentric girl with a secret of her own. The story follows Arima Kousei, a skilled pianist. However, he hasn't played since he played for his mother who died a few years ago."

        constraintLayoutDetail.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
            }

            override fun onSwipeRight() {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

            override fun onSwipeTop() {
                val intent = Intent(applicationContext, MediaPlayerActivity::class.java)
                startActivity(intent)
            }

            override fun onSwipeBottom() {
            }
        })
    }
}
