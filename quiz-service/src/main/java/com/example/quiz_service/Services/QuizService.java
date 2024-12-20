package com.example.quiz_service.Services;

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


    public ResponseEntity<String> createQuiz(String category, int num, String title) {
        //call the generate url -RestTemplate
        List<Integer>questions=

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
//        Optional<Quiz> quiz=quizRepo.findById(id);
//        List<Questions>questionsFromDb=quiz.get().getQuestions();
//        List<QuestionWrapper>questionForUser=new ArrayList<>();
//
//        for(Questions q:questionsFromDb){
//            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestion(),q.getOption_a(),q.getOption_b(),q.getOption_c(),q.getOption_d());
//            questionForUser.add(qw);
//
//        }
//        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
//        Optional<Quiz> quizfromdatabase=quizRepo.findById(id);
//        List<Questions>questions=quizfromdatabase.get().getQuestions();
//        int count=0;
//        int it=0;
//        for (Response r:responses){
//            if(r.getResponse().equalsIgnoreCase(questions.get(it).getAnswer())){
//                count++;
//            }
//            it++;
//        }
//        return new ResponseEntity<>(count,HttpStatus.OK);

    }
}
