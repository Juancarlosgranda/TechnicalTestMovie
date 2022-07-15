package com.jc.app.technical.presentation.ui.model

import android.os.Parcelable
import com.jc.app.technical.domain.model.MovieModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val description: String,
    val voteCount: String,
    val releaseDate: String,
    val popularity: String,
    val urlImage: String
) : Parcelable {
    companion object {
        fun toMovie(movieModel: MovieModel) = Movie(
            title = movieModel.title,
            description = movieModel.description,
            voteCount = movieModel.voteCount,
            releaseDate = movieModel.releaseDate,
            popularity = movieModel.popularity,
            urlImage = movieModel.urlImage
        )
    }

}