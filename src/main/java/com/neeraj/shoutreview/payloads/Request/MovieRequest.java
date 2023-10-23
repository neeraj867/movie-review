package com.neeraj.shoutreview.payloads.Request;

import com.neeraj.shoutreview.domain.Genre;
import com.neeraj.shoutreview.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private Genre genre;
    public Movie toMovie() {
        return Movie.builder().title(this.title).genre(this.genre).rating(0.0).build();
    }
}
