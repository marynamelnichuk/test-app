package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
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

    @GetMapping(value="/{testId}", produces = "application/json")
    public ResponseEntity<TestDTO> getTest(@PathVariable Integer userId, @PathVariable Integer testId) {
        TestDTO test = null;
        try {
            test = service.getTest(testId);
            return new ResponseEntity<>(test, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestDTO> createTest(@PathVariable Integer userId, @RequestBody TestCreateDTO test) {
        TestDTO savedTest = null;
        try {
            savedTest = service.addTest(test, userId);
        } catch (AlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(savedTest, HttpStatus.OK);
    }

    @DeleteMapping(value="/{testId}", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteTest(@PathVariable Integer testId) {
        try {
            service.deleteTest(testId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
