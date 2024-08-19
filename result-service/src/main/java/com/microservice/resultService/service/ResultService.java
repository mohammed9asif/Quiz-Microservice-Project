package com.microservice.resultService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.resultService.model.Response;

@Service
public class ResultService {
	
	QuestionServiceInterface questionService;
	
	public ResultService(QuestionServiceInterface questionService) {
		this.questionService = questionService;
	}
	public int getResultForUserResponses(List<Response> responses) {
		// TODO Auto-generated method stub
		int result =0;
		for(Response response : responses) {
			int  correct_option = questionService.getCorrectAnswer(response.getQuestionId()); 
			if(correct_option==response.getUser_input())
				result++;
			
		}
		
		return result;
	}

}
