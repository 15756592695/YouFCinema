package com.woniu.tiket.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cinema.pojo.Movie;
import com.woniu.tiket.service.MovieService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
	@Autowired
	private MovieService movieService;
	
	@org.junit.Test
	public void test() {
		List<Movie> movies = movieService.findAllMovies();
		System.out.println(movies);
	}
}
