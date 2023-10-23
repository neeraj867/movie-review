package com.neeraj.shoutreview.service;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.payloads.Response.MovieResponse;

import java.util.List;

public interface MovieService {
    MovieResponse findMovie(String title);
    List<MovieResponse> findMoviesByGenre(String genre);
}
