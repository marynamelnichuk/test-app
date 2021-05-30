package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseDTO;
import com.mmelnychuk.bootapp.testsapp.model.TestBase;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;

@Component
public class TestBaseMapper implements Mapper {

    public TestBaseDTO mapToDto(TestBase testBase) {
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
