package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestToCompleteDTO;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TestToCompleteMapper {

    public TestToCompleteDTO mapToDto(TestAssignment assignment) {
        TestToCompleteDTO dto = new TestToCompleteDTO();
        dto.setId(assignment.getId());
        Test test = assignment.getTest();
        dto.setTestId(test.getId());
        dto.setTestName(test.getName());
        dto.setMaxMark(test.getTotalMark());
        dto.setUserEmail(test.getTestBase().getOwner().getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(assignment.getDueDate());
        dto.setDueDate(date);
        return dto;
    }

}
