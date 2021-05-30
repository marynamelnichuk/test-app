package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import com.mmelnychuk.bootapp.testsapp.model.TestResult;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TestResultMapper implements Mapper {

    public TestResultDTO mapToDto(TestResult result) {
        TestResultDTO resultDTO = new TestResultDTO();
        TestAssignment assignment = result.getAssignment();
        Test test = assignment.getTest();
        resultDTO.setTestName(test.getName());
        resultDTO.setUserEmail(assignment.getUser().getEmail());
        resultDTO.setMaxMark(test.getTotalMark());
        resultDTO.setId(result.getId());
        resultDTO.setMark(result.getEstimation());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(result.getCompletedDate());
        resultDTO.setCompletedDate(date);
        return resultDTO;
    }

}
