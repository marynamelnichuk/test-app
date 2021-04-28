package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestBaseRepository extends JpaRepository<TestBase, Integer> {

    @Query("SELECT testbase FROM TestBase testbase WHERE testbase.owner.id = :ownerId")
    List<TestBase> findAllByOwnerId(@Param("ownerId") Integer ownerId);

    @Query("SELECT testbase FROM TestBase testbase WHERE testbase.owner.id = :ownerId AND testbase.id = :testBaseId")
    TestBase getTestBaseById(@Param("ownerId") Integer ownerId, @Param("testBaseId") Integer testBaseId);

}