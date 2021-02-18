package com.parth.RatingsData.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.RatingsData.models.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getMovieRatings(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}
}
