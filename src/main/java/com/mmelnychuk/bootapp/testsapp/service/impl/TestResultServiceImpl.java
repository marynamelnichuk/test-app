package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.mapper.TestResultMapper;
import com.mmelnychuk.bootapp.testsapp.model.TestResult;
import com.mmelnychuk.bootapp.testsapp.repository.TestResultRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestResultServiceImpl implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final TestResultMapper testResultMapper;

    public TestResultServiceImpl(TestResultRepository testResultRepository,
                                 TestResultMapper testResultMapper) {
        this.testResultRepository = testResultRepository;
        this.testResultMapper = testResultMapper;
    }

    @Override
    public List<TestResultDTO> getTestResults(Integer userId) {
        List<TestResult> testResults = testResultRepository.findTestResults(userId);
        return testResults.stream().map(testResultMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<TestResultDTO> getMyTestResults(Integer userId) {
        List<TestResult> testResults = testResultRepository.findMyTestResults(userId);
        return testResults.stream().map(testResultMapper::mapToDto).collect(Collectors.toList());
    }

}
