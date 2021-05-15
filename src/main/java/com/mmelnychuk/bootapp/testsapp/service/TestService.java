package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;

import java.util.List;

public interface TestService {

    List<TestDTO> getTests(Integer ownerId);

    TestDTO addTest(TestCreateDTO test, Integer ownerId) throws AlreadyExistException;

    void deleteTest(Integer testId) throws NotFoundException;

    TestDTO getTest(Integer testId) throws NotFoundException;

    Test getTestByName(String testName);
}
