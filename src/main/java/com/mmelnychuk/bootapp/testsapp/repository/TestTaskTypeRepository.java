package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TaskType;
import com.mmelnychuk.bootapp.testsapp.model.TestTaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestTaskTypeRepository extends JpaRepository<TestTaskType, Integer> {

    @Query("SELECT tasktype FROM TestTaskType tasktype WHERE tasktype.type = :type")
    Optional<TestTaskType> findByType(@Param("type") TaskType type);

}
