package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "test_tasks_types")
public class TestTaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy="type", cascade=CascadeType.ALL)
    private Set<TestBaseTask> testBaseTasks;

    public TestTaskType() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<TestBaseTask> getTestBaseTasks() {
        return testBaseTasks;
    }

    public void setTestBaseTasks(Set<TestBaseTask> testBaseTasks) {
        this.testBaseTasks = testBaseTasks;
    }
}
