package com.jc.app.technical.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.jc.app.technical.domain.model.MovieModel

data class MovieListResponse(
    val results: List<MovieResponse>
)

data class MovieResponse(
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerializedName("vote_count")
    val voteCount: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val popularity: String,
    @SerializedName("poster_path")
    val posterPath: String
) {
    fun toMovieModel() = MovieModel(
        id = id,
        title = originalTitle,
        description = overview,
        voteCount = voteCount,
        releaseDate = releaseDate,
        popularity = popularity,
        urlImage = posterPath
    )

}
