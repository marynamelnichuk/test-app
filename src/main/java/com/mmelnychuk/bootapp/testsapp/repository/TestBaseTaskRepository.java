package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBaseTaskRepository extends JpaRepository<TestBaseTask, Integer> {

    @Query("SELECT testbasetask FROM TestBaseTask testbasetask WHERE testbasetask.testBase.id = :testBaseId")
    List<TestBaseTask> findAllByTestBaseId(@Param("testBaseId") Integer testBaseId);


}
