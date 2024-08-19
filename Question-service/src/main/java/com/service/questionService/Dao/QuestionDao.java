package com.service.questionService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.questionService.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);

	@Query("Select id from Question where category= :category order by Random() limit :noQuestions")
	List<Integer> findByCategoryAndNoOfQuestionRandom(String category, int noQuestions);

}
