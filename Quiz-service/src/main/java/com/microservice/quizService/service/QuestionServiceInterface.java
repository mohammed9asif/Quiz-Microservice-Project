package com.microservice.quizService.service;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservice.quizService.model.QuestionDto;



@FeignClient(value="QUESTION-SERVICE")
public interface QuestionServiceInterface {

	@GetMapping(value = "questions/quiz-question-ids")
	public ResponseEntity<List<Integer>> getQuizQuestionIds(@RequestParam String category,
			@RequestParam int noQuestions);
	
	
	
	/*
	 * @PostMapping(value = "questions/quiz-questions") public
	 * ResponseEntity<List<QuestionDto>> getQuizQuestion (@RequestBody List<Integer>
	 * questionIds);
	 */
	
	@PostMapping(value = "questions/quiz-questions")
	public ResponseEntity<List<QuestionDto>> getQuizQuestion(@RequestBody List<Integer> questionIds);
}
