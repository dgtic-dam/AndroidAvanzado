package com.cybertech.webservicesexample.listener

import com.cybertech.webservicesexample.models.MoviesList

interface OnSetMovieListListener {

    fun onSetMovieList(moviesList: MoviesList)
}