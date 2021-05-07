package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;

@Entity
@Table(name = "task_options")
public class TestBaseTaskOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "correct")
    private Boolean correct;

    @Column(name = "option_value")
    private String  optionValue;

    @ManyToOne
    @JoinColumn(name="test_base_task_id")
    private TestBaseTask testBaseTask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public TestBaseTask getTestBaseTask() {
        return testBaseTask;
    }

    public void setTestBaseTask(TestBaseTask testBaseTask) {
        this.testBaseTask = testBaseTask;
    }
}
