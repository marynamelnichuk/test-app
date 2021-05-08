package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;

@Entity
@Table(name = "test_variants")
public class TestVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="assignment_id")
    protected TestAssignment assignment;

    @ManyToOne
    @JoinColumn(name="task_id")
    protected TestTask testTask;

    @Column(name = "task_order")
    private Integer order;

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

    public TestTask getTestTask() {
        return testTask;
    }

    public void setTestTask(TestTask testTask) {
        this.testTask = testTask;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
