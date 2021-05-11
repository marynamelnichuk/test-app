package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TestBaseMapper {

    public TestBase mapTestBase(TestBaseDTO testBaseDTO) {
        TestBase testBase = new TestBase();
        testBase.setId(testBaseDTO.getId());
        testBase.setName(testBaseDTO.getName());
        testBase.setCategory(testBaseDTO.getCategory());
        testBase.setCategory(testBaseDTO.getCategory());
        testBase.setDescription(testBaseDTO.getDescription());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = LocalDateTime.parse(testBaseDTO.getCreatedDate(), formatter);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(testBase.getCreatedDate());
        testBaseDTO.setCreatedDate(date);
        testBaseDTO.setOwnerId(testBase.getOwner().getId());
        return testBaseDTO;
    }

}
