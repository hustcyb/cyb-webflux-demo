package com.cyb.webflux.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.cyb.webflux.demo.repository.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping("/")
	public String index(final Model model) {
		IReactiveDataDriverContextVariable contextvariable = new ReactiveDataDriverContextVariable(
				movieRepository.findAll(), 1);
		model.addAttribute("movies", contextvariable);
		
		return "index";
	}
}
