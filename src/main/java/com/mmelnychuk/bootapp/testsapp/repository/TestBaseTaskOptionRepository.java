package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.TestBaseTaskOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestBaseTaskOptionRepository extends JpaRepository<TestBaseTaskOption, Integer> {
}
