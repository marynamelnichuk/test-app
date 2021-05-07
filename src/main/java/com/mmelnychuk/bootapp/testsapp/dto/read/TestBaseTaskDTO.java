package com.mmelnychuk.bootapp.testsapp.dto.read;

import java.util.List;

public class TestBaseTaskDTO {

    private Integer id;
    private String question;
    private String type;
    private Integer mark;
    private List<TestBaseTaskOptionDTO> options;
    private String correctQuestion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public List<TestBaseTaskOptionDTO> getOptions() {
        return options;
    }

    public void setOptions(List<TestBaseTaskOptionDTO> options) {
        this.options = options;
    }

    public String getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(String correctQuestion) {
        this.correctQuestion = correctQuestion;
    }
}
