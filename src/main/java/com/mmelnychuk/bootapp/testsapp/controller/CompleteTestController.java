package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestResultCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestToCompleteInfoDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.service.CompleteTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("testsToComplete/{assigmentId}")
public class CompleteTestController {

    private final CompleteTestService completeTestService;

    public CompleteTestController(CompleteTestService completeTestService) {
        this.completeTestService = completeTestService;
    }

    @GetMapping(value="/testInfo", produces = "application/json")
    public ResponseEntity<TestToCompleteInfoDTO> getShortTestInfo(@PathVariable Integer assigmentId) {
        try {
            TestToCompleteInfoDTO infoDTO = completeTestService.getShortTestInfo(assigmentId);
            return new ResponseEntity<>(infoDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestTaskDTO>> getTestTasksToComplete(@PathVariable Integer assigmentId) {
        try {
            List<TestTaskDTO> testTasks = completeTestService.getTestTaskToComplete(assigmentId);
            return new ResponseEntity<>(testTasks, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestResultDTO> completeTest (@PathVariable Integer assigmentId,
                                                       @RequestBody List<TestResultCreateDTO> results) {
        try {
            TestResultDTO resultDTO = completeTestService.completeTest(assigmentId, results);
            return new ResponseEntity<>(resultDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
