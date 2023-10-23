package com.neeraj.shoutreview.payloads.Response;

import com.neeraj.shoutreview.domain.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
    private String title;
    private Double rating;
    private Genre genre;
    private List<ReviewResponse> reviews;
}
