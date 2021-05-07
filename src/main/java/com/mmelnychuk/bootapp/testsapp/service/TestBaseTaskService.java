package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseTaskCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;

import java.util.List;

public interface TestBaseTaskService {

    List<TestBaseTaskDTO> getTestBaseTasks(Integer testBaseId);
    TestBaseTaskDTO addTestBaseTask(Integer testBaseId, TestBaseTaskCreateDTO dto);
    TestBaseTask getTestBaseTask(Integer testBaseTaskId);
    void deleteTestBaseTask(Integer testBaseTaskId);

}
