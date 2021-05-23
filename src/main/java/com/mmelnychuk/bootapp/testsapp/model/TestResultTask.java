package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;

@Entity
@Table(name = "test_results_tasks")
public class TestResultTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="test_result_id")
    protected TestResult testResult;

    @ManyToOne
    @JoinColumn(name="task_id")
    protected TestBaseTask testBaseTask;

    @ManyToOne
    @JoinColumn(name="response_id")
    protected TestBaseTaskOption response;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public TestBaseTask getTestBaseTask() {
        return testBaseTask;
    }

    public void setTestBaseTask(TestBaseTask testBaseTask) {
        this.testBaseTask = testBaseTask;
    }

    public TestBaseTaskOption getResponse() {
        return response;
    }

    public void setResponse(TestBaseTaskOption response) {
        this.response = response;
    }
}
