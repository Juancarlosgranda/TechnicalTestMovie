package com.jc.app.technical.domain.extensions

import com.jc.app.technical.domain.utils.Either

fun <R> R.toSuccess(): Either.Success<R> {
    return Either.Success(this)
}

