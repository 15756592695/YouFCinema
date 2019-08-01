package com.cinema.interfaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="YouFCinema-movbackground")
public interface MovieIdCtronller {
	/**
	 * 根据电影名称查询该片所有排片id
	 * @param name
	 * @return
	 */
	@GetMapping("/movie/findid")
	public List<Integer> findAllid(String name);
}
