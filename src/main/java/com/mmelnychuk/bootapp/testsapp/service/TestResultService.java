package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.TestResult;

import java.util.List;

public interface TestResultService {

    List<TestResultDTO> getTestResults (Integer userId) throws NotFoundException;

}
