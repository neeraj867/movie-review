package com.neeraj.shoutreview.service.implementation;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.repository.MovieRepo;
import com.neeraj.shoutreview.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public Movie addMovie(Movie movie) {
        return this.movieRepo.save(movie);
    }
}
