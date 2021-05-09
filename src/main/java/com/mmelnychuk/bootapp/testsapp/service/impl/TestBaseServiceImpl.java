package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.repository.TestBaseRepository;
import com.mmelnychuk.bootapp.testsapp.repository.UserRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestBaseServiceImpl implements TestBaseService {

    private final TestBaseRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public TestBaseServiceImpl(TestBaseRepository testBaseRepository,UserRepository userRepository) {
        this.repository = testBaseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TestBase> getTestBases(Integer ownerId) {
        return repository.findAllByOwnerId(ownerId);
    }

    @Override
    public TestBase saveTestBase(TestBase testBase, Integer ownerId) {
        System.out.println("SAVE TEST BASE" );
        System.out.println("OWNER ID " + ownerId);
        User user = userRepository.findById(ownerId).get();
        System.out.println("USER" + user);
        testBase.setOwner(user);
        return repository.save(testBase);
    }

    @Override
    public TestBase getTestBaseById(Integer ownerId, Integer testBaseId) {
        return repository.getTestBaseById(ownerId, testBaseId);
    }

    @Override
    public TestBase getTestBaseByName(String testBaseName) {
        return repository.getTestBaseByName(testBaseName).orElseThrow();
    }

    @Override
    public void deleteTestBase(Integer ownerId, Integer testBaseId) {
        TestBase testBaseToDelete = getTestBaseById(ownerId, testBaseId);
        repository.delete(testBaseToDelete);
    }

    @Override
    public TestBase getTestBaseById(Integer testBaseId) {
        return repository.findById(testBaseId).orElseThrow();
    }

}
