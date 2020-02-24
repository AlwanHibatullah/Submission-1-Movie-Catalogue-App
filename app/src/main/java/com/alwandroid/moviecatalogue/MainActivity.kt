package com.alwandroid.moviecatalogue

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MovieAdapter
    private lateinit var dataTitle: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPoster: TypedArray
    private lateinit var dataDate: Array<String>
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = MovieAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val detailMovieIntent = Intent(this@MainActivity, DetailActivity::class.java)
            detailMovieIntent.putExtra(DetailActivity.EXTRA_MOVIE, movies[position])
            startActivity(detailMovieIntent)
        }
    }

    private fun prepare(){
        dataTitle = resources.getStringArray(R.array.data_movie_title)
        dataDescription = resources.getStringArray(R.array.data_movie_description)
        dataPoster = resources.obtainTypedArray(R.array.data_poster)
        dataDate = resources.getStringArray(R.array.data_movie_date)
    }

    private fun addItem(){
        for (position in dataTitle.indices){
            val movie = Movie(
                dataPoster.getResourceId(position, -1),
                dataTitle[position],
                dataDescription[position],
                dataDate[position]
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }
}
