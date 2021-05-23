package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestBaseCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.AlreadyExistException;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import java.util.List;

public interface TestBaseService {

    List<TestBaseDTO> getTestBases(Integer ownerId);

    TestBaseDTO saveTestBase(TestBaseCreateDTO testBaseDTO, Integer ownerId) throws NotFoundException, AlreadyExistException;

    TestBase getTestBaseById(Integer testBaseId) throws NotFoundException;

    TestBase getTestBaseByName(String testBaseName);

    void deleteTestBase(Integer testBaseId) throws NotFoundException;

    TestBaseDTO getTestBaseDtoById(Integer testBaseId) throws NotFoundException;
}
