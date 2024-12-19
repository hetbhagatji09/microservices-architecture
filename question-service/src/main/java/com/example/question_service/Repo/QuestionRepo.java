package com.example.question_service.Repo;

import com.example.question_service.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String category);

    @Query(value = "SELECT q.id FROM QUESTIONS q where q.category=:category ORDER BY RANDOM() LIMIT :num",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int num);
}
