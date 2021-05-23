package com.mmelnychuk.bootapp.testsapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "test_assignments")
public class TestAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    protected User user;

    @ManyToOne
    @JoinColumn(name="test_id")
    protected Test test;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime dueDate;

    @OneToMany(mappedBy="assignment", cascade=CascadeType.ALL)
    protected List<TestVariant> variants;

    @OneToMany(mappedBy="assignment", cascade=CascadeType.ALL)
    protected List<TestResult> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public List<TestVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<TestVariant> variants) {
        this.variants = variants;
    }

    public List<TestResult> getResults() {
        return results;
    }

    public void setResults(List<TestResult> results) {
        this.results = results;
    }
}
