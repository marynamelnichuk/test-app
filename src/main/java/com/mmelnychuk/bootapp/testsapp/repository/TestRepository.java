package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query("SELECT test FROM Test test WHERE test.testBase.owner.id = :userId")
    List<Test> findAllTests(@Param("userId") Integer userId);

    @Query("SELECT test FROM Test test WHERE test.name = :testName")
    Optional<Test> findOneByName(@Param("testName") String testName);

}
