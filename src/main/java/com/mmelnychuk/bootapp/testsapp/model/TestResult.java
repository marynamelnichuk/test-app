package com.mmelnychuk.bootapp.testsapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="assignment_id")
    protected TestAssignment assignment;

    @Column(name = "estimation")
    private Integer estimation;

    @Column(name = "completed_date")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime completedDate;

    @OneToMany(mappedBy="testResult", cascade=CascadeType.ALL)
    protected List<TestResultTask> testResultTasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TestAssignment getAssignment() {
        return assignment;
    }

    public void setAssignment(TestAssignment assignment) {
        this.assignment = assignment;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }
}
