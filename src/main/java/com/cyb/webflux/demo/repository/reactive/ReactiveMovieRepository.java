package com.cyb.webflux.demo.repository.reactive;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

import com.cyb.webflux.demo.domain.Movie;
import com.cyb.webflux.demo.repository.MovieRepository;

@Repository
public class ReactiveMovieRepository implements MovieRepository {
	
	private static List<Movie> movies = new ArrayList<>();
	
	static {
		movies.add(new Movie("Polar (2019)", 64));
		movies.add(new Movie("Iron Man (2008)", 79));
		movies.add(new Movie("The Shawshank Redemption (1994)", 93));
		movies.add(new Movie("Forrest Gump (1994)", 83));
		movies.add(new Movie("Glass (2019)", 70));
	}

	@Override
	public Flux<Movie> findAll() {
		// Simulate big list of data, streaming it every 2 second delay
		return Flux.fromIterable(movies).delayElements(Duration.ofSeconds(2));
	}

}
