package com.neeraj.shoutreview.service.implementation;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.exceptions.ResourceNotFoundException;
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
    @Override
    public void deleteMovie(Long id) {
        Movie movie = this.movieRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("movie","id",id));
        this.movieRepo.delete(movie);
    }
    @Override
    public Movie updateMovie(Long id, Movie movie) {
        Movie getMovie = this.movieRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("movie","id",id));
        getMovie.setTitle(movie.getTitle());
        getMovie.setGenre(movie.getGenre());
        Movie response = this.movieRepo.save(getMovie);
        return response;
    }
}
