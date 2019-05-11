package com.cyb.webflux.demo.repository;

import com.cyb.webflux.demo.domain.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository {

	Flux<Movie> findAll();
}
