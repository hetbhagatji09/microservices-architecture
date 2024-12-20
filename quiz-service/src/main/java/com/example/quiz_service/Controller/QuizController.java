package com.example.quiz_service.Controller;

import com.example.quiz_service.Model.QuestionWrapper;
import com.example.quiz_service.Model.Response;
import com.example.quiz_service.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestParam String category,@RequestParam int num,@RequestParam String title){
        return quizService.createQuiz(category,num,title);

    }
    @GetMapping("/quiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity <Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);


    }

}
