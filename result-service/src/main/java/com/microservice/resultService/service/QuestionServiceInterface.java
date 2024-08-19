package com.microservice.resultService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value="QUESTION-SERVICE")
public interface QuestionServiceInterface {
	
	@GetMapping(value = "questions/getAnswer/{id}")
	public int getCorrectAnswer(@PathVariable int id);
}
