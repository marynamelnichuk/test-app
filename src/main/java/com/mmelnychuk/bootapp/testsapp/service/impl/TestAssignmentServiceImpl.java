package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestAssignmentCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestToCompleteDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.mapper.TestAssignmentMapper;
import com.mmelnychuk.bootapp.testsapp.mapper.TestToCompleteMapper;
import com.mmelnychuk.bootapp.testsapp.model.AssignmentStatus;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import com.mmelnychuk.bootapp.testsapp.model.TestAssignment;
import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.repository.TestAssignmentRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestAssignmentService;
import com.mmelnychuk.bootapp.testsapp.service.TestService;
import com.mmelnychuk.bootapp.testsapp.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestAssignmentServiceImpl implements TestAssignmentService {

    private final TestAssignmentRepository repository;
    private final TestAssignmentMapper mapper;
    private final TestToCompleteMapper testToCompleteMapper;
    private final UserService userService;
    private final TestService testService;

    public TestAssignmentServiceImpl(TestAssignmentRepository repository, TestAssignmentMapper mapper,
                                     TestToCompleteMapper testToCompleteMapper,
                                     UserService userService, TestService testService) {
        this.repository = repository;
        this.mapper = mapper;
        this.testToCompleteMapper = testToCompleteMapper;
        this.userService = userService;
        this.testService = testService;
    }

    @Override
    public List<TestAssignmentDTO> getTestAssignments(Integer userId) {
        List<TestAssignment> testAssignments = repository.findAllByUserId(userId);
        return testAssignments.stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public TestAssignmentDTO addTestAssignment(TestAssignmentCreateDTO createDTO) throws NotFoundException, AlreadyExistException {
        TestAssignment assignment = new TestAssignment();
        assignment.setStatus(AssignmentStatus.ASSIGNED);
        User userToAssign = userService.getUserByEmail(createDTO.getUserEmail());
        assignment.setUser(userToAssign);
        Test test = testService.getTestByName(createDTO.getTestName());
        assignment.setTest(test);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(createDTO.getDueDate(), formatter);
        LocalDateTime dateTime = date.atStartOfDay();
        assignment.setDueDate(dateTime);
        try {
            TestAssignment savedAssignment = repository.save(assignment);
            return mapper.mapToDto(savedAssignment);
        }catch (Exception e) {
            throw new AlreadyExistException("Assigment with such data already exist.");
        }
    }

    @Override
    public void deleteTestAssignment(Integer testAssignmentId) throws NotFoundException {
        TestAssignment assignment = repository.findById(testAssignmentId)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Assigment with id %s not found.", testAssignmentId)));
        repository.delete(assignment);
    }

    @Override
    public List<TestToCompleteDTO> getTestAssignmentsToComplete(Integer userId) {
        List<TestAssignment> testAssignments = repository.findAllByUserIdToComplete(userId);
        return testAssignments.stream().map(testToCompleteMapper::mapToDto).collect(Collectors.toList());
    }
}
