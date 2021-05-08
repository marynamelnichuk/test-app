package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;

@Entity
@Table(name = "test_results_tasks")
public class TestResultTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

}
