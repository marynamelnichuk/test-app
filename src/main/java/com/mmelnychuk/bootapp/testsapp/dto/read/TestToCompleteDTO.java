package com.mmelnychuk.bootapp.testsapp.dto.read;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

public class TestToCompleteDTO implements DTO {

    private Integer id;
    private String userEmail;
    private String testName;
    private Integer testId;
    private Integer maxMark;
    private String dueDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(Integer maxMark) {
        this.maxMark = maxMark;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
