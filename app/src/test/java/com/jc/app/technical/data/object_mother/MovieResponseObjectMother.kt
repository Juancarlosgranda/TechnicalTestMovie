package com.jc.app.technical.data.object_mother

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jc.app.technical.data.FileReaderUtil
import com.jc.app.technical.data.source.remote.response.MovieListResponse
import java.lang.reflect.Type


class MovieResponseObjectMother {

    companion object {

        fun provideRemoteMoviesFromAssets(): MovieListResponse {
            val listType: Type = object : TypeToken<MovieListResponse>() {}.type

            return Gson().fromJson(
                FileReaderUtil.kotlinReadFileWithNewLineFromResources(fileName = "movieList.json"),
                listType
            )
        }
    }
}
