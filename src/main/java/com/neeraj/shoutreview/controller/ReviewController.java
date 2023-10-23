package com.neeraj.shoutreview.controller;

import com.neeraj.shoutreview.payloads.Request.ReviewRequest;
import com.neeraj.shoutreview.payloads.Response.ReviewResponse;
import com.neeraj.shoutreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/add")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody ReviewRequest reviewRequest) {
        return new ResponseEntity<>(this.reviewService.addReview(reviewRequest.toReview()), HttpStatus.CREATED);
    }
    @GetMapping("/find")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable Long id) {
        return new ResponseEntity<>(this.reviewService.getReviewById(id),HttpStatus.OK);
    }
}
