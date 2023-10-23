package com.neeraj.shoutreview.payloads.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponse {
    private String review;
    private Double rating;
}
