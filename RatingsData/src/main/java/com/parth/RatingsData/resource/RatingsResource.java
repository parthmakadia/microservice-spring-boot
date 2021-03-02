package com.parth.RatingsData.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.RatingsData.models.Rating;
import com.parth.RatingsData.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getMovieRatings(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 5);
	}
	
	@RequestMapping("user/{movieId}")
	public UserRating getMovieUserRatings(@PathVariable("movieId") String movieId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("test1",5),
				new Rating("test2", 6));
		UserRating userRating = new UserRating();
		userRating.setRatings(ratings);
		return userRating;
	}
}
