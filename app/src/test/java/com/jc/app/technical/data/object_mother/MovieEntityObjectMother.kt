package com.jc.app.technical.data.object_mother

import com.jc.app.technical.data.source.local.entity.MovieEntity


class MovieEntityObjectMother {

    companion object {

        fun provideMovieEntityList() : List<MovieEntity> {
            val movieListResponse = MovieResponseObjectMother.provideRemoteMoviesFromAssets()
            return movieListResponse.results.map {
                MovieEntity(
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
