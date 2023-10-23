package com.neeraj.shoutreview.service;

import com.neeraj.shoutreview.domain.Review;
import com.neeraj.shoutreview.payloads.Response.ReviewResponse;

public interface ReviewService {
    ReviewResponse addReview(Review review);
    ReviewResponse getReviewById(Long id);
}
