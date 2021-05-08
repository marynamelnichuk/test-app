package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tests")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "tasks_number")
    private Integer tasksNumber;

    @Column(name = "total_mark")
    private Integer totalMark;

    @ManyToOne
    @JoinColumn(name="test_base_id")
    protected TestBase testBase;

    @OneToMany(mappedBy="test", cascade=CascadeType.ALL)
    protected Set<TestTask> testTasks;

    @OneToMany(mappedBy="test", cascade=CascadeType.ALL)
    protected Set<TestAssignment> assignments;

    Test() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public TestBase getTestBase() {
        return testBase;
    }

    public void setTestBase(TestBase testBase) {
        this.testBase = testBase;
    }

    public Set<TestTask> getTestTasks() {
        return testTasks;
    }

    public void setTestTasks(Set<TestTask> testTasks) {
        this.testTasks = testTasks;
    }
}
