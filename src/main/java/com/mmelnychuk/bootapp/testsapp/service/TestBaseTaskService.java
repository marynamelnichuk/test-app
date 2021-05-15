package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseTaskCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;

import java.util.List;

public interface TestBaseTaskService {

    List<TestBaseTaskDTO> getTestBaseTasks(Integer testBaseId);
    TestBaseTaskDTO addTestBaseTask(Integer testBaseId, TestBaseTaskCreateDTO dto) throws NotFoundException;
    TestBaseTask getTestBaseTask(Integer testBaseTaskId) throws NotFoundException;
    void deleteTestBaseTask(Integer testBaseTaskId) throws NotFoundException;

}
