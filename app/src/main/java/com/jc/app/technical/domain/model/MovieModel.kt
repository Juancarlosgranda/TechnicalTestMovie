package com.jc.app.technical.domain.model

data class MovieModel(
    val id: Int,
    val title: String,
    val description: String,
    val voteCount: String,
    val releaseDate: String,
    val popularity: String,
    val urlImage: String,
)
