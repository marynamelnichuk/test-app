package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class TestBaseMapper {

    public TestBase mapTestBase(TestBaseDTO testBaseDTO) {
        TestBase testBase = new TestBase();
        testBase.setId(testBaseDTO.getId());
        testBase.setName(testBaseDTO.getName());
        testBase.setCategory(testBaseDTO.getCategory());
        testBase.setCategory(testBaseDTO.getCategory());
        testBase.setDescription(testBaseDTO.getDescription());
        LocalDateTime date = LocalDateTime.ofInstant(testBaseDTO.getCreatedDate().toInstant(), ZoneId.systemDefault());
        testBase.setCreatedDate(date);
        return testBase;
    }

    public TestBaseDTO mapTestBaseDTO(TestBase testBase) {
        TestBaseDTO testBaseDTO = new TestBaseDTO();
        testBaseDTO.setId(testBase.getId());
        testBaseDTO.setName(testBase.getName());
        testBaseDTO.setCategory(testBase.getCategory());
        testBaseDTO.setDescription(testBase.getCategory());
        testBaseDTO.setDescription(testBase.getDescription());
        Date date = Date.from(testBase.getCreatedDate().atZone(ZoneId.systemDefault()).toInstant());
        testBaseDTO.setCreatedDate(date);
        testBaseDTO.setOwnerId(testBase.getOwner().getId());
        return testBaseDTO;
    }

}
