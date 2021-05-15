package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.TestBaseCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.mapper.TestBaseMapper;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import com.mmelnychuk.bootapp.testsapp.model.User;
import com.mmelnychuk.bootapp.testsapp.repository.TestBaseRepository;
import com.mmelnychuk.bootapp.testsapp.repository.UserRepository;
import com.mmelnychuk.bootapp.testsapp.service.TestBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestBaseServiceImpl implements TestBaseService {

    private final TestBaseRepository repository;
    private final UserRepository userRepository;
    private final TestBaseMapper mapper;

    @Autowired
    public TestBaseServiceImpl(TestBaseRepository testBaseRepository,UserRepository userRepository,
                               TestBaseMapper mapper) {
        this.repository = testBaseRepository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TestBaseDTO> getTestBases(Integer ownerId) {
        List<TestBase> testBases = repository.findAllByOwnerId(ownerId);
        return testBases.stream().map(mapper::mapTestBaseDTO).collect(Collectors.toList());
    }

    @Override
    public TestBaseDTO saveTestBase(TestBaseCreateDTO testBaseDTO, Integer ownerId) throws NotFoundException, AlreadyExistException {
        User user = userRepository.findById(ownerId).orElseThrow(
                () -> new NotFoundException(String.format("User with id %s not found.", ownerId)));
        TestBase testBaseToCreate = new TestBase();
        testBaseToCreate.setName(testBaseDTO.getName());
        testBaseToCreate.setCategory(testBaseDTO.getCategory());
        testBaseToCreate.setDescription(testBaseDTO.getDescription());
        testBaseToCreate.setOwner(user);
        try {
            TestBase savedTestBase = repository.save(testBaseToCreate);
            return mapper.mapTestBaseDTO(savedTestBase);
        } catch (Exception e) {
            throw new AlreadyExistException("Test base with such data already exist.");
        }
    }

    @Override
    public TestBase getTestBaseById(Integer testBaseId) throws NotFoundException {
        return repository.findById(testBaseId).orElseThrow(() ->
                new NotFoundException(String.format("Test base with id %s not found.", testBaseId)));
    }

    @Override
    public TestBase getTestBaseByName(String testBaseName) {
        return repository.getTestBaseByName(testBaseName).orElseThrow();
    }

    @Override
    public void deleteTestBase(Integer testBaseId) throws NotFoundException {
        TestBase testBaseToDelete = getTestBaseById(testBaseId);
        repository.delete(testBaseToDelete);
    }

    @Override
    public TestBaseDTO getTestBaseDtoById(Integer testBaseId) throws NotFoundException {
        return mapper.mapTestBaseDTO(getTestBaseById(testBaseId));
    }

}
