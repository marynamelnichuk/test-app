package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;

import java.util.List;

public interface TestService {

    List<TestDTO> getTests(Integer ownerId);

    TestDTO addTest(TestCreateDTO test, Integer ownerId);

    void deleteTest(Integer testId);
}
