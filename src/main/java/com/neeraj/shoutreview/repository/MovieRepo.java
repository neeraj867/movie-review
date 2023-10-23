package com.neeraj.shoutreview.repository;

import com.neeraj.shoutreview.domain.Genre;
import com.neeraj.shoutreview.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie,Long> {
    Optional<Movie> findByTitle(String title);
    Optional<List<Movie>> findByGenre(Genre genre);
}
