package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;
import com.mmelnychuk.bootapp.testsapp.service.TestTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("tests/{testId}/testTasks")
public class TestTaskController {

    private final TestTaskService service;

    public TestTaskController(TestTaskService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestTaskDTO>> getTestTasks(@PathVariable Integer testId) {
        List<TestTaskDTO> testTasks = service.getTestTasks(testId);
        return new ResponseEntity<>(testTasks, HttpStatus.OK);
    }

}
