package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import com.mmelnychuk.bootapp.testsapp.model.TestResult;
import org.springframework.stereotype.Component;

@Component
public class TestResultMapper {

    public TestResultDTO mapToDto(TestResult result) {
        TestResultDTO resultDTO = new TestResultDTO();
        TestAssignment assignment = result.getAssignment();
        Test test = assignment.getTest();
        resultDTO.setTestName(test.getName());
        return resultDTO;
    }

}
