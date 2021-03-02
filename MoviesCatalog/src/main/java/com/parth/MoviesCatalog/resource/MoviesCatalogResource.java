package com.parth.MoviesCatalog.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.parth.MoviesCatalog.models.CatalogItem;
import com.parth.MoviesCatalog.models.Movie;
import com.parth.MoviesCatalog.models.Rating;
import com.parth.MoviesCatalog.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MoviesCatalogResource {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/getCatalogList/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		// get all rated movies
		
		WebClient.Builder builder = WebClient.builder();
		List<Rating> ratingsData = new ArrayList<>();
		ratingsData.add(new Rating("test",5));
		
		UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/"+ userId, UserRating.class); 
		
		return userRating.getRatings().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+ rating.getMovieId(), Movie.class);
//			Movie movie = webClientBuilder.build()
//				.get()
//				.uri("http://localhost:8081/movies/"+ rating.getMovieId())
//				.retrieve()
//				.bodyToMono(Movie.class)
//				.block();
			return new CatalogItem(movie.getName(), "Desc", rating.getRatings());
		}).collect(Collectors.toList());
		// for each movie call movie info service and get details
		// put them all together
	}
}
