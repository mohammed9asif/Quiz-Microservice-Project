package com.microservice.quizService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.quizService.model.QuestionDto;
import com.microservice.quizService.model.Quiz;
import com.microservice.quizService.model.QuizDto;
import com.microservice.quizService.service.QuizService;

@RestController
public class QuizController {
	
	
	/* API design 
	 * quizzes/generate?category='val'&noQuesitons=val - generate a quiz
	 * 
	 * quizzes/list
	 * 
	 * quizzes/{id} - fetch quiz details by ID
	 * 
	 * quizzes/{id} - update an existing quiz
	 * 
	 * quizzes/{id} - delete an existing quiz
	 * */
	QuizService quizService;
	
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@GetMapping(value = "quizzes/list")
	public List<Quiz> getAllQuizzes(){
		return quizService.getAllQuizzes();
	}
	
	@GetMapping(value = "quizzes/{id}")
	public ResponseEntity<Quiz> getQuizById(@PathVariable int id){
		return quizService.getQuizById(id);
	}
	@PostMapping(value="quizzes/generate")
	public ResponseEntity<Quiz> generateQuiz(@RequestBody QuizDto quizDto){
		
		Quiz quiz=quizService.generateQuiz(quizDto);
		return new ResponseEntity<Quiz>(quiz,HttpStatus.CREATED);
	}
	
	@GetMapping(value="quizzes/play/{id}")
	public ResponseEntity<List<QuestionDto>> getQuizQuestionsFromIds(@PathVariable int id){
		
		List<QuestionDto> questions = quizService.getQuizQuestionsFromIds(id);
		return new ResponseEntity<List<QuestionDto>>(questions,HttpStatus.CREATED);
	}
	
}
