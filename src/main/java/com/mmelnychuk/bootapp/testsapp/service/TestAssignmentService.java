package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestAssignmentCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;

import java.util.List;

public interface TestAssignmentService {

    List<TestAssignmentDTO> getTestAssignments(Integer userId);

    TestAssignmentDTO addTestAssignment(TestAssignmentCreateDTO createDTO);

    void deleteTestAssignment(Integer testAssignmentId);
}
