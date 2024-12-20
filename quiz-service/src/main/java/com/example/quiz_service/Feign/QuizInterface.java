package com.example.quiz_service.Feign;

import com.example.quiz_service.Model.QuestionWrapper;
import com.example.quiz_service.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/genarate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);
    //getQuestions
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questions);
    //getScore
    @PostMapping("question/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>responses);
}
