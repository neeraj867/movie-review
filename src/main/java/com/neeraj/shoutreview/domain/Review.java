package com.neeraj.shoutreview.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neeraj.shoutreview.payloads.Response.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@Table(name="review_table")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieReview;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "movie_id",nullable = false)
    @JsonIgnore
    private Movie movie;
    @CreationTimestamp
    private Date createdTime;
    @CreationTimestamp
    private Date updatedTime;
    public static ReviewResponse toReviewResponse(Review review) {
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }
    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList) {
        if(Objects.isNull(reviewList)) {
            return new ArrayList<>();
        }
        return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}
