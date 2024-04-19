package com.chootadev.interview.sharedelementtry.common

object Constants {
    const val POSTER_URL = "https://image.tmdb.org/t/p/original"
}

fun String.tmdbPoster(): String {
    return "${Constants.POSTER_URL}${this}"
}