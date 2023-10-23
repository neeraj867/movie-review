package com.neeraj.shoutreview.controller;

import com.neeraj.shoutreview.payloads.Request.MovieRequest;
import com.neeraj.shoutreview.payloads.Response.ApiResponse;
import com.neeraj.shoutreview.payloads.Response.MovieResponse;
import com.neeraj.shoutreview.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }
    @PutMapping("/movie/update/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable long id,@RequestBody MovieRequest movieRequest) {
        return new ResponseEntity<>(this.adminService.updateMovie(id,movieRequest.toMovie()).toMovieResponse(),HttpStatus.OK);
    }
    @DeleteMapping("/movie/delete/{id}")
    public ResponseEntity<ApiResponse> deleteMovie(@PathVariable long id) {
        this.adminService.deleteMovie(id);
        return new ResponseEntity<>(new ApiResponse("movie deleted successfully","accomplished"),HttpStatus.OK);
    }
}
