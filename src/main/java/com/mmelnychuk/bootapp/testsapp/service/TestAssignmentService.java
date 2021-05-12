package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestAssignmentCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestToCompleteDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;

import java.util.List;

public interface TestAssignmentService {

    List<TestAssignmentDTO> getTestAssignments(Integer userId);

    TestAssignmentDTO addTestAssignment(TestAssignmentCreateDTO createDTO) throws NotFoundException;

    void deleteTestAssignment(Integer testAssignmentId);

    List<TestToCompleteDTO> getTestAssignmentsToComplete(Integer userId);
}
