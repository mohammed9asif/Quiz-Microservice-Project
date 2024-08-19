package com.service.questionService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.questionService.Dao.QuestionDao;
import com.service.questionService.model.Question;
import com.service.questionService.model.QuestionDto;

@Service
public class QuestionService {
	
	QuestionDao questionDao;
	
	public QuestionService(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}
	
	public List<Question> getAllQuestions(){
		return questionDao.findAll();
	}

	public String addQuestion(Question question) {
		
		try {
			questionDao.save(question);
		}catch(Exception e) {
			return "fail";
		}
		return "success";
	}

	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Question> question = questionDao.findById(id);
		if(question.isPresent())
			return question.get();
		return null;
		
	}

	public List<Question> getQuestionByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}

	public List<Integer> generateQuizRandom(String category, int noQuestions) {
		// TODO Auto-generated method stub
		return questionDao.findByCategoryAndNoOfQuestionRandom(category,noQuestions);
	}

	public List<QuestionDto> getQuestionsForQuiz(List<Integer> questionIds) {
		// TODO Auto-generated method stub
		List<Question> questionsFromdb = questionDao.findAllById(questionIds);
		
		List<QuestionDto> quizQuestions = new ArrayList<QuestionDto>();
		
		questionsFromdb.forEach(question ->{
			quizQuestions.add(new QuestionDto(question.getId(),
											question.getQuestionText(),
											question.getOption1(),
											question.getOption2(),
											question.getOption3(),
											question.getOption4()));
		});
		
		return quizQuestions;
		
	}

	public int getCorrectOptionForId(int id) {
		// TODO Auto-generated method stub
		Question question = questionDao.findById(id).get();
		return question.getCorrectOption();
	}
}
