package com.mmelnychuk.bootapp.testsapp.model;

import javax.persistence.*;

@Entity
@Table(name = "tests_tasks")
public class TestTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

}
