package com.microservice.quizService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.quizService.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
