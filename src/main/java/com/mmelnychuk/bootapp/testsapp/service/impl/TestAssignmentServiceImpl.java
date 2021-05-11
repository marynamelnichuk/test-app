package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestAssignmentCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
import com.mmelnychuk.bootapp.testsapp.repository.TestAssignmentRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAssignmentServiceImpl implements TestAssignmentService {

    private final TestAssignmentRepository repository;

    public TestAssignmentServiceImpl(TestAssignmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestAssignmentDTO> getTestAssignments(Integer userId) {
        return null;
    }

    @Override
    public TestAssignmentDTO addTestAssignment(TestAssignmentCreateDTO createDTO) {
        return null;
    }

    @Override
    public void deleteTestAssignment(Integer testAssignmentId) {

    }
}
