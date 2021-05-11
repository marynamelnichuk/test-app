package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestTaskRepository extends JpaRepository<TestTask, Integer>  {

    @Query("SELECT testTask FROM TestTask testTask WHERE testTask.test.id = :testId")
    List<TestTask> findAllTestTasksByTestId(@Param("testId") Integer testId);

}
