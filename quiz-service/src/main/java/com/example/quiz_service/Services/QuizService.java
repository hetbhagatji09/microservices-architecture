package com.example.quiz_service.Services;

import com.example.quiz_service.Feign.QuizInterface;
import com.example.quiz_service.Model.QuestionWrapper;
import com.example.quiz_service.Model.Quiz;
import com.example.quiz_service.Model.Response;
import com.example.quiz_service.Repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int num, String title) {
        List<Integer>questionsId=quizInterface.generateQuestionForQuiz(category,num).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionsId);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz=quizRepo.findById(id).get();
        List<Integer> questionsIds=quiz.getQuestionsId();
        List<QuestionWrapper> questionWrappers=quizInterface.getQuestionsFromId(questionsIds).getBody();
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {

        ResponseEntity<Integer>score= quizInterface.getScore(responses);
        return score;

    }
}
