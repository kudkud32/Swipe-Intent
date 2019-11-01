package id.rackspira.swipeintent.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.rackspira.swipeintent.R
import id.rackspira.swipeintent.ui.adapter.AdapterHome
import id.rackspira.swipeintent.util.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.overridePendingTransition(
            R.anim.anim_slide_in_right,
            R.anim.anim_slide_out_right
        )

        val adapter = AdapterHome(this)
        rvContentHome.layoutManager = LinearLayoutManager(this)
        rvContentHome.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
