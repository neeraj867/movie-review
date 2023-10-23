package com.neeraj.shoutreview.controller;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.payloads.Response.MovieResponse;
import com.neeraj.shoutreview.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/title")
    public ResponseEntity<MovieResponse> findMovie(@RequestParam String title) {
        return new ResponseEntity<>(this.movieService.findMovie(title), HttpStatus.OK);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<MovieResponse>> findMoviesByGenre(@RequestParam String genre) {
        return new ResponseEntity<>(this.movieService.findMoviesByGenre(genre),HttpStatus.OK);
    }
}
