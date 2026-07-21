package com.jagruti.myfirstapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jagruti.myfirstapp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerViewBinding
    lateinit var mRecyclerView: RecyclerView
    lateinit var newsArrayList : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageArray = arrayOf(R.drawable.myimage,R.drawable.virat,R.drawable.pic0,R.drawable.sachin,R.drawable.checkbox,R.drawable.bg_text,
            R.drawable.myimage,R.drawable.virat,R.drawable.pic0,R.drawable.sachin,R.drawable.checkbox,R.drawable.bg_text)

        val  newsHeading = arrayOf("Delhi Protest Updates: Thousands of CJP protesters, including those supporting activist Sonam Wangchuk, marched toward Parliament despite heavy barricading and police pushback.",
            "J&K Flash Floods: At least 14 people died and many are missing following severe flash floods and landslides in Jammu and Kashmir's Poonch and Rajouri districts.",
            "Parliament Monsoon Session: The first day of Parliament witnessed severe disruptions and walkouts as the Opposition protested against various burning issues and the Delhi demonstrations.",
            "National Film Awards: Mammootty, Kartik Aaryan, and Yami Gautam were named Best Actors at the 72nd National Film Awards.",
            "FIFA World Cup 2026: Spain defeated Argentina in the final to win their second World Cup title, with Unai Simón winning the Golden Glove.",
            "Ram temple donation 'theft' row: Simple case of crime, don't politicise it, says SC",
            "Delhi Protest Updates: Thousands of CJP protesters, including those supporting activist Sonam Wangchuk, marched toward Parliament despite heavy barricading and police pushback.",
            "J&K Flash Floods: At least 14 people died and many are missing following severe flash floods and landslides in Jammu and Kashmir's Poonch and Rajouri districts.",
            "Parliament Monsoon Session: The first day of Parliament witnessed severe disruptions and walkouts as the Opposition protested against various burning issues and the Delhi demonstrations.",
            "National Film Awards: Mammootty, Kartik Aaryan, and Yami Gautam were named Best Actors at the 72nd National Film Awards.",
            "FIFA World Cup 2026: Spain defeated Argentina in the final to win their second World Cup title, with Unai Simón winning the Golden Glove.",
            "Ram temple donation 'theft' row: Simple case of crime, don't politicise it, says SC")

        binding.rvNews.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for (index in imageArray.indices){
                val news= News(newsHeading[index], imageArray[index])
            newsArrayList.add(news)
        }
        binding.rvNews.adapter = MyNewsAdapter(newsArrayList,this)
    }
}