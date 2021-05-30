package com.mmelnychuk.bootapp.testsapp.dto.create;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

import java.util.List;

public class TestBaseTaskCreateDTO implements DTO {

    private String question;
    private String type;
    private Integer mark;
    private List<String> options;
    private String correctOption;

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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
