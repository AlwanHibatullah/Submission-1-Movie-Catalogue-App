package com.alwandroid.moviecatalogue

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var movies = arrayListOf<Movie>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val movie = getItem(position) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    override fun getItem(position: Int): Any = movies[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = movies.size

    private inner class ViewHolder internal constructor(view: View){
        private val txtTitle: TextView = view.findViewById(R.id.txt_movie_title)
        private val txtDescription: TextView = view.findViewById(R.id.txt_movie_description)
        private val imgPoster: ImageView = view.findViewById(R.id.img_poster)

        internal fun bind(movie: Movie){
            txtTitle.text = movie.title
            txtDescription.text = movie.description
            imgPoster.setImageResource(movie.poster!!)
        }
    }
}