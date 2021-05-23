package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{ownerId}/testbases")
public class TestBaseController {

    private final TestBaseService testBaseService;

    @Autowired
    public TestBaseController(TestBaseService testBaseService) {
        this.testBaseService = testBaseService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestBaseDTO>> getTestBases(@PathVariable Integer ownerId) {
        List<TestBaseDTO> testBaseDTOS = testBaseService.getTestBases(ownerId);
        return new ResponseEntity<>(testBaseDTOS, HttpStatus.OK);
    }

    @GetMapping(value="/{testBaseId}", produces = "application/json")
    public ResponseEntity<TestBaseDTO> getTestBase(@PathVariable Integer testBaseId) {
        try {
            TestBaseDTO testBase = testBaseService.getTestBaseDtoById(testBaseId);
            return new ResponseEntity<>(testBase, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestBaseDTO> createTestBase(@PathVariable Integer ownerId, @RequestBody TestBaseCreateDTO testBase) {
        TestBaseDTO createdTestBase = null;
        try {
            createdTestBase = testBaseService.saveTestBase(testBase, ownerId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (AlreadyExistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdTestBase, HttpStatus.OK);
    }

    @DeleteMapping(value="/{testBaseId}", produces = "application/json")
    public ResponseEntity<Void> deleteTestBase(@PathVariable Integer testBaseId) {
        try {
            testBaseService.deleteTestBase(testBaseId);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
