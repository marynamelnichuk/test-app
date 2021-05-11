package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;

import java.util.List;

public interface TestTaskService {

    List<TestTaskDTO> getTestTasks(Integer testId);

}
