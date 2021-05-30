package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository <TestResult, Integer> {

    @Query("SELECT result FROM TestResult result WHERE result.assignment.test.testBase.owner.id = :userId")
    List<TestResult> findTestResults(@Param("userId") Integer userId);

    @Query("SELECT result FROM TestResult result WHERE result.assignment.user.id = :userId")
    List<TestResult> findMyTestResults(@Param("userId") Integer userId);

}
