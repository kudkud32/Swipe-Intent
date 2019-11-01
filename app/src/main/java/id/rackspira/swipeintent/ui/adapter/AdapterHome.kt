package id.rackspira.swipeintent.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.rackspira.swipeintent.R
import id.rackspira.swipeintent.ui.DetailContentActivity
import id.rackspira.swipeintent.util.OnSwipeTouchListener

class AdapterHome(private val context: Context) : RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_home, parent, false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val metrics = context.resources.displayMetrics
        val width = metrics.widthPixels
        val height = width / 2.7

        Picasso.get().load("https://akibento.com/blog/wp-content/uploads/external/yup2ImwuPj9q4vsfDmChXkuPXx02wJK5.png").resize(width, height.toInt()).into(holder.ivBannerContent)
        holder.tvTitleContent.text = "Shigatsu wa Kimi no Uso"
        holder.tvDescriptionContent.text = "A piano prodigy who lost his ability to play after suffering a traumatic event in his childhood is forced back into the spotlight by an eccentric girl with a secret of her own. The story follows Arima Kousei, a skilled pianist. However, he hasn't played since he played for his mother who died a few years ago."

        holder.cvContentHome.setOnTouchListener(object : OnSwipeTouchListener(context) {
            override fun onSwipeLeft() {
                val intent = Intent(context, DetailContentActivity::class.java)
                intent.putExtra("StatusFrom", "Adapter")
                context.startActivity(intent)
            }
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvContentHome = itemView.findViewById<CardView>(R.id.cvContentHome)!!
        var ivBannerContent = itemView.findViewById<ImageView>(R.id.ivBannerContent)!!
        var tvTitleContent = itemView.findViewById<TextView>(R.id.tvTitleContent)!!
        var tvDescriptionContent = itemView.findViewById<TextView>(R.id.tvDescriptionContent)!!
    }
}