package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestAssignmentRepository extends JpaRepository<TestAssignment, Integer>  {

    @Query("SELECT assignment FROM TestAssignment assignment WHERE assignment.test.testBase.owner.id = :userId")
    List<TestAssignment> findAllByUserId(@Param("userId") Integer userId);

    @Query("SELECT assignment FROM TestAssignment assignment WHERE assignment.user.id = :userId")
    List<TestAssignment> findAllByUserIdToComplete(@Param("userId") Integer userId);

}
