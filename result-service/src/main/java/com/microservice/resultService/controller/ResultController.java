package com.microservice.resultService.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.resultService.model.Response;
import com.microservice.resultService.service.ResultService;

@RestController
public class ResultController {

	
	/* Api Desing for result controller 
	 * 
	 * quizzes/{id}/submit - submit answers for quiz
	 * 
	 * results/{id} - fetch quiz result by id for user
	 * 
	 * 
	 * */
	
	ResultService resultService;
	public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}
	public int getResultForUserResponse(@RequestBody List<Response> responses){
		
		return resultService.getResultForUserResponses(responses);
		
	}
}
