package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TestAssignmentMapper {

    public TestAssignmentDTO mapToDto(TestAssignment assignment) {
        TestAssignmentDTO dto = new TestAssignmentDTO();
        dto.setId(assignment.getId());
        Test test = assignment.getTest();
        dto.setTestId(test.getId());
        dto.setTestName(test.getName());
        dto.setStatus(assignment.getStatus().name());
        dto.setUserEmail(test.getTestBase().getOwner().getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(assignment.getDueDate());
        dto.setDueDate(date);
        return dto;
    }

}
