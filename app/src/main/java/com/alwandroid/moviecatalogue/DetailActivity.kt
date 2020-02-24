package com.alwandroid.moviecatalogue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle: TextView = findViewById(R.id.txt_movie_title)
        val tvDate: TextView = findViewById(R.id.txt_movie_date)
        val tvDescription: TextView = findViewById(R.id.txt_movie_description)
        val imgPoster: ImageView = findViewById(R.id.img_poster)

        val movie = intent.getParcelableExtra(EXTRA_MOVIE) as Movie
        tvTitle.text = movie.title.toString()
        tvDate.text = movie.date.toString()
        tvDescription.text = movie.description.toString()
        imgPoster.setImageResource(movie.poster!!)

        if (supportActionBar != null){
            supportActionBar?.title = movie.title.toString()
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}
