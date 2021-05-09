package com.mmelnychuk.bootapp.testsapp.service;

import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import java.util.List;

public interface TestBaseService {

    List<TestBase> getTestBases(Integer ownerId);

    TestBase saveTestBase(TestBase testBase, Integer ownerId);

    TestBase getTestBaseById(Integer ownerId, Integer testBaseId);

    TestBase getTestBaseByName(String testBaseName);

    void deleteTestBase(Integer ownerId, Integer testBaseId);

    TestBase getTestBaseById(Integer testBaseId);
}
