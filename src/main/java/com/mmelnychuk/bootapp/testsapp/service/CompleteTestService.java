package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestResultCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;

import java.util.List;

public interface CompleteTestService {

    List<TestTaskDTO> getTestTaskToComplete(Integer assigmentId) throws NotFoundException;

    TestResultDTO completeTest(Integer assigmentId,
                                      List<TestResultCreateDTO> testResults) throws NotFoundException;

}
