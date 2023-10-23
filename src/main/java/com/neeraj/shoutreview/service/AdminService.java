package com.neeraj.shoutreview.service;

import com.neeraj.shoutreview.domain.Movie;

public interface AdminService {
    Movie addMovie(Movie movie);
    void deleteMovie(Long id);
    Movie updateMovie(Long id,Movie movie);
}
