package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.TestResult;
import com.mmelnychuk.bootapp.testsapp.service.TestResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("{userId}/testResults")
public class TestResultController {

    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestResultDTO>> getTestBase(@PathVariable Integer userId) {
        try {
            List<TestResultDTO> testResultDTOs = testResultService.getTestResults(userId);
            return new ResponseEntity<>(testResultDTOs, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
