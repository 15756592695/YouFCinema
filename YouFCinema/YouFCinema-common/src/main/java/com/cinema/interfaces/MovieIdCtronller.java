package com.cinema.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="movie-provider")
public interface MovieIdCtronller {
	/**
	 * 根据电影名称查询该片所有排片id
	 * @param name
	 * @return
	 */ 
	@GetMapping("/movie/findid/{name}")
	public List<Integer> findAllid(@PathVariable("name")  String name);
}
