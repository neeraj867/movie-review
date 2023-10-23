package com.neeraj.shoutreview.service.implementation;

import com.neeraj.shoutreview.domain.Movie;
import com.neeraj.shoutreview.domain.Review;
import com.neeraj.shoutreview.payloads.Response.ReviewResponse;
import com.neeraj.shoutreview.repository.MovieRepo;
import com.neeraj.shoutreview.repository.ReviewRepo;
import com.neeraj.shoutreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public ReviewResponse addReview(Review review) {
        Movie movie = this.movieRepo.findById(review.getMovie().getId()).orElseThrow();
        Review savedReview = this.reviewRepo.save(review);
        Double average = this.reviewRepo.getReviewAverage(movie.getId());
        movie.setRating(average);
        this.movieRepo.save(movie);
        return Review.toReviewResponse(savedReview);
    }
    @Override
    public ReviewResponse getReviewById(Long id) {
        Review review = this.reviewRepo.findById(id).orElseThrow();
        return Review.toReviewResponse(review);
    }
}
