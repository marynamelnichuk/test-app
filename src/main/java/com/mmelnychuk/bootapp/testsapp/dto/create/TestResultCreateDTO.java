package com.mmelnychuk.bootapp.testsapp.dto.create;

import java.util.List;

public class TestResultCreateDTO {

    private Integer testTaskId;
    private List<Integer> answers;

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
}
