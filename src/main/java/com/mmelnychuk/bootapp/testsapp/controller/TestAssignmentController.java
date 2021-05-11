package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestAssignmentDTO;
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
    public ResponseEntity<Collection<TestAssignmentDTO>> getTests(@PathVariable Integer userId) {
        List<TestAssignmentDTO> testTasks = service.getTestAssignments(userId);
        return new ResponseEntity<>(testTasks, HttpStatus.OK);
    }

}
