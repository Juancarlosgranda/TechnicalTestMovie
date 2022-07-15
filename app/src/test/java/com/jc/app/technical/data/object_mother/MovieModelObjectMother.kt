package com.jc.app.technical.data.object_mother

import com.jc.app.technical.domain.model.MovieModel


class MovieModelObjectMother {

    companion object {

        fun provideMovieModelList() : List<MovieModel> {
            val movieListResponse = MovieResponseObjectMother.provideRemoteMoviesFromAssets()
            return movieListResponse.results.map {
                MovieModel(
                    id = it.id,
                    title = it.originalTitle,
                    description = it.overview,
                    voteCount = it.voteCount,
                    releaseDate = it.releaseDate,
                    popularity = it.popularity,
                    urlImage = it.posterPath
                )
            }
        }
    }
}
