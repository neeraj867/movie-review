package com.neeraj.shoutreview.service.implementation;

import com.neeraj.shoutreview.domain.Genre;
import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.exceptions.ResourceNotFoundException;
import com.neeraj.shoutreview.payloads.Response.MovieResponse;
import com.neeraj.shoutreview.repository.MovieRepo;
import com.neeraj.shoutreview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public MovieResponse findMovie(String title) {
        // to handle exception
        Movie movie = movieRepo.findByTitle(title).orElseThrow(()->new ResourceNotFoundException("movie","title"));
        return movie.toMovieResponse();
    }

    @Override
    public List<MovieResponse> findMoviesByGenre(String genre) {
        if(Arrays.stream(Genre.values()).noneMatch(g->g.toString().equals(genre))){
            return new ArrayList<>();
        }
        // to handle exception
        List<Movie> moviesList = this.movieRepo.findByGenre(Genre.valueOf(genre)).orElseThrow(()->new ResourceNotFoundException("movie","genre"));
        List<MovieResponse> movieResponseList = moviesList.stream().sorted(Comparator.comparing(Movie::getRating,Comparator.reverseOrder())).map(Movie::toMovieResponse).collect(Collectors.toList());
        return movieResponseList;
    }
}
