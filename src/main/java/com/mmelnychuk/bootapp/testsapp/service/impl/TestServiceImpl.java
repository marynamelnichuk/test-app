package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.mapper.TestMapper;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;
import com.mmelnychuk.bootapp.testsapp.model.TestTask;
import com.mmelnychuk.bootapp.testsapp.repository.TestRepository;
import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import com.mmelnychuk.bootapp.testsapp.service.TestService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final TestMapper mapper;
    private final TestBaseService testBaseService;

    public TestServiceImpl(TestRepository repository, TestMapper mapper, TestBaseService testBaseService) {
        this.repository = repository;
        this.mapper = mapper;
        this.testBaseService = testBaseService;
    }

    @Override
    public List<TestDTO> getTests(Integer ownerId) {
        List<Test> tests = repository.findAllTests(ownerId);
        return tests.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TestDTO addTest(TestCreateDTO test, Integer ownerId) {
        Test testToSave = new Test();
        testToSave.setName(test.getName());
        testToSave.setTasksNumber(test.getTasksNumber());
        testToSave.setTotalMark(test.getTotalMark());
        TestBase testBase = testBaseService.getTestBaseByName(test.getTestBaseName());
        testToSave.setTestBase(testBase);
        Test savedTest = repository.save(testToSave);

        List<TestBaseTask> testBaseTasks = testBase.getTestBaseTasks();
        Set<Integer> indexes = new HashSet<>();
        Random rand = new Random();
        while (indexes.size() != test.getTasksNumber()) {
            indexes.add(rand.nextInt(testBaseTasks.size()-1));
        }

        for(Integer index : indexes) {
            TestTask testTask = new TestTask();
            testTask.setTest(savedTest);
            TestBaseTask testBaseTask = testBaseTasks.get(index);
            testTask.setTestBaseTask(testBaseTask);
        }
      /*  Random rand = new Random(); //instance of random class
        int upperbound = 25;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);*/

        return mapper.mapToDTO(savedTest);
    }

    @Override
    public void deleteTest(Integer testId) {
        Test test = repository.findById(testId).orElseThrow();
        repository.delete(test);
    }
}
