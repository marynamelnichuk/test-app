package com.mmelnychuk.bootapp.testsapp.dto.read;

public class TestTaskDTO {

    private Integer id;
    private TestBaseTaskDTO testBaseTaskDTO;
    private Integer mark;

    public TestBaseTaskDTO getTestBaseTaskDTO() {
        return testBaseTaskDTO;
    }

    public void setTestBaseTaskDTO(TestBaseTaskDTO testBaseTaskDTO) {
        this.testBaseTaskDTO = testBaseTaskDTO;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
