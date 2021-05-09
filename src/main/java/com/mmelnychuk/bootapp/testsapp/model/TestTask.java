package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tests_tasks")
public class TestTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mark")
    private Double mark;

    @ManyToOne
    @JoinColumn(name="test_id")
    protected Test test;

    @ManyToOne
    @JoinColumn(name="test_task_id")
    protected TestBaseTask testBaseTask;

    @OneToMany(mappedBy="testTask", cascade=CascadeType.ALL)
    protected Set<TestVariant> variants;

    public TestTask() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Set<TestVariant> getVariants() {
        return variants;
    }

    public void setVariants(Set<TestVariant> variants) {
        this.variants = variants;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public TestBaseTask getTestBaseTask() {
        return testBaseTask;
    }

    public void setTestBaseTask(TestBaseTask testBaseTask) {
        this.testBaseTask = testBaseTask;
    }
}
