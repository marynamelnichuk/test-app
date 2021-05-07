package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseTaskCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.mapper.TestBaseTaskMapper;
import com.mmelnychuk.bootapp.testsapp.model.*;
import com.mmelnychuk.bootapp.testsapp.repository.TestBaseTaskOptionRepository;
import com.mmelnychuk.bootapp.testsapp.repository.TestBaseTaskRepository;
import com.mmelnychuk.bootapp.testsapp.repository.TestTaskTypeRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseTaskService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TestBaseTaskServiceImpl implements TestBaseTaskService {

    private final TestBaseTaskRepository repository;
    private final TestTaskTypeRepository testTaskTypeRepository;
    private final TestBaseTaskOptionRepository testBaseTaskOptionRepository;
    private final TestBaseService testBaseService;
    private final TestBaseTaskMapper mapper;

    public TestBaseTaskServiceImpl(TestBaseTaskRepository repository,
                                   TestTaskTypeRepository testTaskTypeRepository,
                                   TestBaseTaskOptionRepository testBaseTaskOptionRepository,
                                   TestBaseService testBaseService,
                                   TestBaseTaskMapper mapper) {
        this.repository = repository;
        this.testTaskTypeRepository = testTaskTypeRepository;
        this.testBaseTaskOptionRepository = testBaseTaskOptionRepository;
        this.testBaseService = testBaseService;
        this.mapper = mapper;
    }

    @Override
    public List<TestBaseTaskDTO> getTestBaseTasks(Integer testBaseId) {
        List<TestBaseTask> testBaseTasks = repository.findAllByTestBaseId(testBaseId);
        return testBaseTasks.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestBaseTaskDTO addTestBaseTask(Integer testBaseId, TestBaseTaskCreateDTO dto) {
        TestBaseTask taskToSave = new TestBaseTask();
        taskToSave.setQuestion(dto.getQuestion());
        TestTaskType type = testTaskTypeRepository.findByType(TaskType.valueOf(dto.getType())).get();
        taskToSave.setType(type);
        taskToSave.setMark(dto.getMark());
        TestBase testBase = testBaseService.getTestBaseById(testBaseId);
        taskToSave.setTestBase(testBase);

        TestBaseTask savedTask = repository.save(taskToSave);
        Set<TestBaseTaskOption> options = new HashSet<>();

        TestBaseTaskOption correctAnswer = new TestBaseTaskOption();
        correctAnswer.setOptionValue(dto.getCorrectQuestion());
        correctAnswer.setCorrect(true);
        correctAnswer.setTestBaseTask(savedTask);
        TestBaseTaskOption savedCorrectOption = testBaseTaskOptionRepository.save(correctAnswer);
        options.add(savedCorrectOption);
        if(!dto.getType().equals(TaskType.SHORT_ANSWER.name())) {
            for(String optionName : dto.getOptions()) {
                TestBaseTaskOption answer = new TestBaseTaskOption();
                answer.setOptionValue(optionName);
                answer.setCorrect(false);
                answer.setTestBaseTask(savedTask);
                TestBaseTaskOption savedOption = testBaseTaskOptionRepository.save(answer);
                options.add(savedOption);
            }
        }
        savedTask.setTestBaseTaskOptions(options);
        return mapper.mapToDTO(savedTask);
    }

    @Override
    public TestBaseTask getTestBaseTask(Integer testBaseTaskId) {
        return repository.findById(testBaseTaskId).orElseThrow();
    }

    @Override
    public void deleteTestBaseTask(Integer testBaseTaskId) {
        TestBaseTask task = getTestBaseTask(testBaseTaskId);
        repository.delete(task);
    }
}
