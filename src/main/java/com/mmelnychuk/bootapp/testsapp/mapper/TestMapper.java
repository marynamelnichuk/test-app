package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestDTO;
import com.mmelnychuk.bootapp.testsapp.model.Test;
import org.springframework.stereotype.Component;

@Component
public class TestMapper implements Mapper {

    public TestDTO mapToDTO(Test test) {
        TestDTO dto = new TestDTO();
        dto.setId(test.getId());
        dto.setName(test.getName());
        dto.setTasksNumber(test.getTasksNumber());
        dto.setTestBaseName(test.getTestBase().getName());
        dto.setTotalMark(test.getTotalMark());
        return dto;
    }

}
