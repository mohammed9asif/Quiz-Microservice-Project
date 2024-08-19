package com.microservice.quizService.model;

public class QuizDto {
	
	private String category;
	private int noQuestions;
	private String Title;
	
	
	
	public QuizDto(String category, int noQuestions, String title) {
		super();
		this.category = category;
		this.noQuestions = noQuestions;
		Title = title;
	}
	public QuizDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNoQuestions() {
		return noQuestions;
	}
	public void setNoQuestions(int noQuestions) {
		this.noQuestions = noQuestions;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	

}
