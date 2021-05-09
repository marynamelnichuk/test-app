package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseTaskCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{userId}/tests")
public class TestController {

    private final TestService service;

    @Autowired
    public TestController(TestService service) {
        this.service = service;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestDTO>> getTests(@PathVariable Integer userId) {
        List<TestDTO> tests = service.getTests(userId);
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestDTO> createTest(@PathVariable Integer userId, @RequestBody TestCreateDTO test) {
        TestDTO savedTest = service.addTest(test, userId);
        return new ResponseEntity<>(savedTest, HttpStatus.OK);
    }

    @DeleteMapping(value="/{testId}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteTest(@PathVariable Integer testId) {
        service.deleteTest(testId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
