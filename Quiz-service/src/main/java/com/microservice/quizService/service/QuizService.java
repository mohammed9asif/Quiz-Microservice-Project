package com.microservice.quizService.service;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.quizService.Dao.QuizDao;
import com.microservice.quizService.model.QuestionDto;
import com.microservice.quizService.model.Quiz;
import com.microservice.quizService.model.QuizDto;

@Service
public class QuizService {

	QuizDao quizDao;
	QuestionServiceInterface questionService;
	public QuizService(QuizDao quizDao,QuestionServiceInterface questionService) {
		this.quizDao = quizDao;
		this.questionService = questionService;
	}
	public List<Quiz> getAllQuizzes() {
		// TODO Auto-generated method stub
		return quizDao.findAll();
	}

	public Quiz generateQuiz(QuizDto quizDto) {
		// TODO Auto-generated method stub
		List<Integer> questionIds = questionService.getQuizQuestionIds(quizDto.getCategory(), quizDto.getNoQuestions()).getBody();
		Quiz quiz = new Quiz();
		quiz.setNoQuestions(quizDto.getNoQuestions());
		quiz.setQuestionIds(questionIds);
		Quiz qu =quizDao.save(quiz);
		return qu;
	}
	public ResponseEntity<Quiz> getQuizById(int id) {
		// TODO Auto-generated method stub
		Quiz quiz = quizDao.findById(id).get();
		
		
		return new ResponseEntity<>(quiz,HttpStatus.OK);
		
	}
	public List<QuestionDto> getQuizQuestionsFromIds(int id) {
		// TODO Auto-generated method 
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		List<QuestionDto> list = questionService.getQuizQuestion(questionIds).getBody();
		return list;
	}

}
