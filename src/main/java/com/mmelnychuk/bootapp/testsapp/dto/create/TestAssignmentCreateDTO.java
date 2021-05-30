package com.mmelnychuk.bootapp.testsapp.dto.create;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

public class TestAssignmentCreateDTO implements DTO {

    private String testName;
    private String userEmail;
    private String dueDate;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
