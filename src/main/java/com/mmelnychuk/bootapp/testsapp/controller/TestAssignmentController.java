package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestAssignmentCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestToCompleteDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.service.TestAssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("{userId}/testsAssignments")
public class TestAssignmentController {

    private final TestAssignmentService service;

    public TestAssignmentController(TestAssignmentService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestAssignmentDTO>> getTestAssignments(@PathVariable Integer userId) {
        List<TestAssignmentDTO> testTasks = service.getTestAssignments(userId);
        return new ResponseEntity<>(testTasks, HttpStatus.OK);
    }

    @GetMapping(value="/toComplete", produces = "application/json")
    public ResponseEntity<Collection<TestToCompleteDTO>> getTestAssignmentsToComplete(@PathVariable Integer userId) {
        List<TestToCompleteDTO> testTasks = service.getTestAssignmentsToComplete(userId);
        return new ResponseEntity<>(testTasks, HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestAssignmentDTO> createTestAssignment(@RequestBody TestAssignmentCreateDTO assignment)
            throws NotFoundException {
        TestAssignmentDTO savedAssignment = null;
        try {
            savedAssignment = service.addTestAssignment(assignment);
        } catch (AlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedAssignment, HttpStatus.OK);
    }

    @DeleteMapping(value="/{testAssignmentId}", produces = "application/json")
    public ResponseEntity<Void> deleteTestAssignment(@PathVariable Integer userId, @PathVariable Integer testAssignmentId) {
        try {
            service.deleteTestAssignment(testAssignmentId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
