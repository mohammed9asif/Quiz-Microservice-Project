package com.microservice.quizService.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int noQuestions;
	
	@ElementCollection
	List<Integer> questionIds;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(int id, int noQuestions, List<Integer> questionIds) {
		super();
		this.id = id;
		this.noQuestions = noQuestions;
		this.questionIds = questionIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNoQuestions() {
		return noQuestions;
	}
	public void setNoQuestions(int noQuestions) {
		this.noQuestions = noQuestions;
	}
	public List<Integer> getQuestionIds() {
		return questionIds;
	}
	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
	
}
