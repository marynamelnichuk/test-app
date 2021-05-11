package com.mmelnychuk.bootapp.testsapp.controller;

import com.mmelnychuk.bootapp.testsapp.dto.TestBaseCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.mapper.TestBaseMapper;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/{ownerId}/testbases")
public class TestBaseController {

    private final TestBaseService testBaseService;
    private final TestBaseMapper testBaseMapper;

    @Autowired
    public TestBaseController(TestBaseService testBaseService, TestBaseMapper testBaseMapper) {
        this.testBaseService = testBaseService;
        this.testBaseMapper = testBaseMapper;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Collection<TestBaseDTO>> getTestBases(@PathVariable Integer ownerId) {
        List<TestBase> testBases = testBaseService.getTestBases(ownerId);
        List<TestBaseDTO> testBaseDTOS = testBases.stream().map(testBaseMapper::mapTestBaseDTO).collect(Collectors.toList());;
        return new ResponseEntity<>(testBaseDTOS, HttpStatus.OK);
    }

    @GetMapping(value="/{testBaseId}", produces = "application/json")
    public ResponseEntity<TestBaseDTO> getTestBase(@PathVariable Integer ownerId, @PathVariable Integer testBaseId) {
        TestBase testBase = testBaseService.getTestBaseById(ownerId, testBaseId);
        TestBaseDTO testBaseDTO = testBaseMapper.mapTestBaseDTO(testBase);
        return new ResponseEntity<>(testBaseDTO, HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<TestBaseDTO> createTestBase(@PathVariable Integer ownerId, @RequestBody TestBaseCreateDTO testBase) {
        TestBase testBaseToCreate = new TestBase();
        testBaseToCreate.setName(testBase.getName());
        testBaseToCreate.setCategory(testBase.getCategory());
        testBaseToCreate.setDescription(testBase.getDescription());
        TestBase createdTestBase = testBaseService.saveTestBase(testBaseToCreate, ownerId);
        return new ResponseEntity<>(testBaseMapper.mapTestBaseDTO(createdTestBase), HttpStatus.OK);
    }

    @DeleteMapping(value="/{testBaseId}", produces = "application/json")
    public ResponseEntity deleteTestBase(@PathVariable Integer ownerId, @PathVariable Integer testBaseId) {
        System.out.println("DELTE TEST BAASE");
        testBaseService.deleteTestBase(ownerId, testBaseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
