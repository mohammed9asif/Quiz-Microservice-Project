package com.service.questionService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.questionService.model.Question;
import com.service.questionService.model.QuestionDto;
import com.service.questionService.service.QuestionService;

import jakarta.websocket.server.PathParam;

@RestController
public class QuestionController {

	
	// Api Design
	/* 
	 * questions - to add a question to service
	 * 
	 * questions - to get all questions at once
	 * 
	 * questions/{id} - retrive a question by id
	 * 
	 * questions/{id} - update a question by id
	 * 
	 * questions/{id} - delete a question by id
	 * 
	 * questions/category/{category} - fetch questions by category
	 * 
	 * Methods which are accessible by other microservice
	 * 
	 * questions/quiz?category='val'&numQuestion='val' - returns list of random noQuesiton ids with category
	 * 
	 * 
	 * After getting the ids of questions quiz service can request to getQuestion
	 * but we cant return the Question object , cause it has correct_option also.
	 * So we will create QuestionDto for transferring only question and options
	 */
	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService=questionService;
	}
	/* Get Mapping to get all the questions present in db */
	
	@GetMapping(value = "questions")
	public List<Question> getAllQuestions(){
		//return new ResponseEntity(questionService.getAllQuestions(), HttpStatus.OK);
		return questionService.getAllQuestions();
	}
	
	/* Post Mapping to add the questions present in db */
	@PostMapping(value="questions")
	public ResponseEntity<String> addQuestion(@RequestBody Question question){
		
		String message = questionService.addQuestion(question);
		if(message.equals("success"))
			return new ResponseEntity<String>(message, HttpStatus.CREATED);
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value = "questions/{id}")
	public ResponseEntity<Question> getParticularQuestion(@PathVariable int id){
		
		Question question = questionService.getQuestionById(id);
		
		if(question==null)
			return new ResponseEntity<Question>(question,HttpStatus.NOT_FOUND);
		return new ResponseEntity<Question>(question, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "questions/category/{category}")
	public ResponseEntity<List<Question>> getParticularQuestionByCategory(@PathVariable String category){
		
		List<Question> question = questionService.getQuestionByCategory(category);
		
		if(question==null)
			return new ResponseEntity<>(question,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(question, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "questions/quiz-question-ids")
	public ResponseEntity<List<Integer>> getQuizQuestionIds(@RequestParam String category,
			@RequestParam int noQuestions){
		
		List<Integer> questionIds = questionService.generateQuizRandom(category,noQuestions);
		
		if(questionIds.isEmpty())
			return new ResponseEntity<>(questionIds,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(questionIds, HttpStatus.OK);
		
	}
	
	
	
	@PostMapping(value = "questions/quiz-questions")
	public ResponseEntity<List<QuestionDto>> getQuizQuestion(@RequestBody List<Integer> questionIds){
		
		List<QuestionDto> questions = questionService.getQuestionsForQuiz(questionIds);
		
		if(questionIds.isEmpty())
			return new ResponseEntity<>(questions,HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(questions, HttpStatus.OK);
		
	}
	
	
	@GetMapping(value = "questions/getAnswer/{id}")
	public int getCorrectAnswer(@PathVariable int id) {
		return questionService.getCorrectOptionForId(id);
	}
}
