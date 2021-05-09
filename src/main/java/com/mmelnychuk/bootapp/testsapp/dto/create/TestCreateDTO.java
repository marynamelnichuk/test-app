package com.mmelnychuk.bootapp.testsapp.dto.create;

public class TestCreateDTO {

    private String name;
    private Integer tasksNumber;
    private Integer totalMark;
    private String testBaseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTasksNumber() {
        return tasksNumber;
    }

    public void setTasksNumber(Integer tasksNumber) {
        this.tasksNumber = tasksNumber;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public String getTestBaseName() {
        return testBaseName;
    }

    public void setTestBaseName(String testBaseName) {
        this.testBaseName = testBaseName;
    }
}
