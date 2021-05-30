package com.mmelnychuk.bootapp.testsapp.dto.read;

import com.mmelnychuk.bootapp.testsapp.dto.DTO;

public class TestToCompleteInfoDTO implements DTO {

    private String testName;
    private String testDescription;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }
}
