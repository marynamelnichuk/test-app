package com.mmelnychuk.bootapp.testsapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_base_tasks")
public class TestBaseTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinColumn(name="test_base_id")
    private TestBase testBase;

    @ManyToOne
    @JoinColumn(name="task_type_id")
    private TestTaskType type;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime createdDate;

    @PrePersist
    public void beforeSave() {
        createdDate = LocalDateTime.now();
    }

    public TestBaseTask() {}

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

    public TestBase getTestBase() {
        return testBase;
    }

    public void setTestBase(TestBase testBase) {
        this.testBase = testBase;
    }

    public TestTaskType getType() {
        return type;
    }

    public void setType(TestTaskType type) {
        this.type = type;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
