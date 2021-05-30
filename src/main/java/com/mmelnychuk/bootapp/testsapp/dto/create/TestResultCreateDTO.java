package com.mmelnychuk.bootapp.testsapp.dto.create;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

import java.util.List;

public class TestResultCreateDTO implements DTO {

    private Integer testTaskId;
    private List<Integer> answers;
    private String shortResponse;

    public Integer getTestTaskId() {
        return testTaskId;
    }

    public void setTestTaskId(Integer testTaskId) {
        this.testTaskId = testTaskId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public String getShortResponse() {
        return shortResponse;
    }

    public void setShortResponse(String shortResponse) {
        this.shortResponse = shortResponse;
    }
}
