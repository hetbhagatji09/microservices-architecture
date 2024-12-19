package com.example.question_service.Controller;

import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Questions;
import com.example.question_service.Model.Response;
import com.example.question_service.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/questions")
    public ResponseEntity<List<Questions>> getQuestions(){
        return questionService.getQuestions();

    }
    @GetMapping("/category/{cat}")
    public ResponseEntity<List<Questions>> getByCategory(@PathVariable String cat){
        return questionService.getBycategory(cat);

    }
    @PostMapping("/question")
    public ResponseEntity<String> add(@RequestBody Questions questions){
        return questionService.addQuestion(questions);
    }
    @DeleteMapping("/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }
    //genarate -get questions for quiz
    @GetMapping("genarate")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category,@RequestParam Integer numQuestions){
        return questionService.generateQuestionForQuiz(category,numQuestions);
    }
    //getQuestions
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questions){
        return questionService.getQuestionsFromId(questions);
    }
    //getScore
    @PostMapping("getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>responses){

        return questionService.calculateScore(responses);

    }

}
