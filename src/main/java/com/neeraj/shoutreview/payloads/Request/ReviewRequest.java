package com.neeraj.shoutreview.payloads.Request;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
    private String movieReview;
    private Double rating;
    private Long movieId;
    public Review toReview() {
        return Review.builder()
                .movieReview(this.movieReview)
                .rating(this.rating)
                .movie(Movie.builder()
                        .id(this.movieId)
                        .build())
                .build();
    }
}
