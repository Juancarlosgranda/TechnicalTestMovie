package com.jc.app.technical.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jc.app.technical.domain.model.MovieModel

@Entity
data class MovieEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "vote_count") val voteCount: String,
    @ColumnInfo(name = "release_date") val releaseDate: String,
    @ColumnInfo(name = "popularity") val popularity: String,
    @ColumnInfo(name = "url_image") val urlImage: String,
) {
    fun toMovieModel() = MovieModel(
        id = id,
        title = title,
        description = description,
        voteCount = voteCount,
        releaseDate = releaseDate,
        popularity = popularity,
        urlImage = urlImage
    )
}