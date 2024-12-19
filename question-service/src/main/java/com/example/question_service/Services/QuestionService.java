package com.example.question_service.Services;


import com.example.question_service.Model.QuestionWrapper;
import com.example.question_service.Model.Questions;
import com.example.question_service.Model.Response;
import com.example.question_service.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    public ResponseEntity<List<Questions>> getQuestions(){
        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
        }

    }

    public ResponseEntity<List<Questions>> getBycategory(String category) {
        return new ResponseEntity<>(questionRepo.findByCategory(category),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Questions questions) {

        try{
            questionRepo.save(questions);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try {
            if (questionRepo.existsById(id)) {
                questionRepo.deleteById(id);
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return new ResponseEntity<>("An error occurred while deleting the question", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Integer>> generateQuestionForQuiz(String category, Integer numQuestions) {
        return new ResponseEntity<>(questionRepo.findRandomQuestionByCategory(category,numQuestions),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questions) {
        List<QuestionWrapper>wrappers=new ArrayList<>();
        for(Integer id:questions){
            Questions q=questionRepo.findById(id).get();
            QuestionWrapper wrapper=new QuestionWrapper();
            wrapper.setQuestion(q.getQuestion());
            wrapper.setOption_a(q.getOption_a());
            wrapper.setOption_b(q.getOption_b());
            wrapper.setOption_c(q.getOption_c());
            wrapper.setOption_d(q.getOption_d());
            wrappers.add(wrapper);

        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);


    }

    public ResponseEntity<Integer> calculateScore(List<Response> responses) {
        int count=0;
        for(Response response:responses){
            Questions q=questionRepo.findById(response.getId()).get();
            if(q.getAnswer().equalsIgnoreCase(response.getResponse())){
                count++;
            }
        }
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
