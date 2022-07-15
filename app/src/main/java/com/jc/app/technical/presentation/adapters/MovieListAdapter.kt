package com.jc.app.technical.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jc.app.technical.databinding.ItemMovieBinding
import com.jc.app.technical.presentation.extensions.setSafeOnClickListener
import com.jc.app.technical.presentation.ui.model.Movie

class MovieListAdapter(
    private val onItemClickListener: (model: Movie) -> Unit
) : ListAdapter<Movie, MovieListAdapter.MovieViewHolder>(
    MovieDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
        holder.binding.root.setSafeOnClickListener {
            onItemClickListener.invoke(model)
        }
    }

    class MovieViewHolder(
        val binding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MovieViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
                return MovieViewHolder(binding)
            }
        }
    }

    class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}

