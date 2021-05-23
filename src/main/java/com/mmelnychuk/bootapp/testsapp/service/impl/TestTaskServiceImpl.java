package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;
import com.mmelnychuk.bootapp.testsapp.mapper.TestBaseTaskMapper;
import com.mmelnychuk.bootapp.testsapp.model.TestTask;
import com.mmelnychuk.bootapp.testsapp.repository.TestTaskRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestTaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestTaskServiceImpl  implements TestTaskService {

    private final TestTaskRepository repository;
    private final TestBaseTaskMapper testBaseTaskMapper;

    public TestTaskServiceImpl(TestTaskRepository repository, TestBaseTaskMapper testBaseTaskMapper) {
        this.repository = repository;
        this.testBaseTaskMapper = testBaseTaskMapper;
    }

    @Override
    public List<TestTaskDTO> getTestTasks(Integer testId) {
        List<TestTask> testTasks = repository.findAllTestTasksByTestId(testId);
        List<TestTaskDTO> dtos = new ArrayList<>();
        for(TestTask testTask : testTasks) {
            TestTaskDTO dto = new TestTaskDTO();
            dto.setId(testTask.getId());
            dto.setMark(testTask.getMark());
            dto.setTestBaseTaskDTO(testBaseTaskMapper.mapToDTO(testTask.getTestBaseTask()));
            dtos.add(dto);
        }
        return dtos;
        //return repository.findAllTestTasksByTestId(testId);
    }
}
