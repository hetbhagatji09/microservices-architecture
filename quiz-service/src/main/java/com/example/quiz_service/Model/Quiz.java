package com.example.quiz_service.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    //when you have numbers so we can go for element collection instead of manytomanu
    @ElementCollection
    private List<Integer>questionsId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getQuestionsId() {
        return questionsId;
    }

    public void setQuestions(List<Integer> questionsId) {
        this.questionsId = questionsId;
    }
}
