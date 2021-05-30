package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.mapper.TestMapper;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;
import com.mmelnychuk.bootapp.testsapp.model.TestTask;
import com.mmelnychuk.bootapp.testsapp.repository.TestRepository;
import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.repository.TestTaskRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import com.mmelnychuk.bootapp.testsapp.service.TestService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository repository;
    private final TestMapper mapper;
    private final TestBaseService testBaseService;
    private final TestTaskRepository testTaskRepository;

    public TestServiceImpl(TestRepository repository, TestMapper mapper, TestBaseService testBaseService,
                           TestTaskRepository testTaskRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.testBaseService = testBaseService;
        this.testTaskRepository = testTaskRepository;
    }

    @Override
    public List<TestDTO> getTests(Integer ownerId) {
        List<Test> tests = repository.findAllTests(ownerId);
        return tests.stream().map(mapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public TestDTO addTest(TestCreateDTO test, Integer ownerId) throws AlreadyExistException {
        Test testToSave = new Test();
        testToSave.setName(test.getName());
        testToSave.setTasksNumber(test.getTasksNumber());
        testToSave.setTotalMark(test.getTotalMark());
        TestBase testBase = testBaseService.getTestBaseByName(test.getTestBaseName());
        testToSave.setTestBase(testBase);
        try {
            Test savedTest = repository.save(testToSave);

            List<TestBaseTask> testBaseTasks = testBase.getTestBaseTasks();
            ArrayList<Integer> indexes = new ArrayList<Integer>();
            for (int i=0; i<test.getTasksNumber(); i++) {
                indexes.add(i);
            }
            Collections.shuffle(indexes);

            List<TestTask> testTasks = new ArrayList<>();
            int sum = 0;
            for (Integer index : indexes) {
                TestTask testTask = new TestTask();
                testTask.setTest(savedTest);
                TestBaseTask testBaseTask = testBaseTasks.get(index);
                testTask.setTestBaseTask(testBaseTask);
                sum += testBaseTask.getMark();
                testTasks.add(testTask);
            }
            Double onePoint = ((double)(test.getTotalMark())/sum);

            for (TestTask testTask : testTasks) {
                Double mark = (double) Math.round(testTask.getTestBaseTask().getMark());
                testTask.setMark((int) (mark * onePoint));
                testTaskRepository.save(testTask);
            }
            return mapper.mapToDTO(savedTest);
        }catch (Exception e) {
            throw new AlreadyExistException("Test with such data already exist.");
        }
    }

    @Override
    public void deleteTest(Integer testId) throws NotFoundException {
        Test test = repository.findById(testId).orElseThrow(() ->
                new NotFoundException(String.format("Test with id %s not found.", testId)));
        repository.delete(test);
    }

    @Override
    public TestDTO getTest(Integer testId) throws NotFoundException {
        Test test = repository.findById(testId).orElseThrow(() ->
                new NotFoundException(String.format("Test with id %s not found.", testId)));
        return mapper.mapToDTO(test);
    }

    @Override
    public Test getTestByName(String testName) {
        return repository.findOneByName(testName).orElseThrow();
    }
}
