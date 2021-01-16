package com.mmelnychuk.bootapp.testsapp.repository;

import com.mmelnychuk.bootapp.testsapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
