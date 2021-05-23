package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskOptionDTO;
import com.mmelnychuk.bootapp.testsapp.model.TaskType;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTaskOption;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TestBaseTaskMapper {

    public TestBaseTaskDTO mapToDTO(TestBaseTask testBaseTask) {
        TestBaseTaskDTO testBaseTaskDTO = new TestBaseTaskDTO();
        testBaseTaskDTO.setId(testBaseTask.getId());
        testBaseTaskDTO.setQuestion(testBaseTask.getQuestion());
        testBaseTaskDTO.setType(testBaseTask.getType().getType().name());
        testBaseTaskDTO.setMark(testBaseTask.getMark());
        List<TestBaseTaskOption> taskOptions = testBaseTask.getTestBaseTaskOptions();
        TestBaseTaskOption correctQuestion = taskOptions.stream()
                .filter(TestBaseTaskOption::getCorrect).findFirst().orElseThrow();
        testBaseTaskDTO.setCorrectQuestion(correctQuestion.getOptionValue());
        if (!testBaseTask.getType().getType().equals(TaskType.SHORT_ANSWER)) {
            List<TestBaseTaskOptionDTO> options = taskOptions.stream()
                    .map(option -> new TestBaseTaskOptionDTO(option.getId(), option.getOptionValue()))
                    .collect(Collectors.toList());
            testBaseTaskDTO.setOptions(options);
        }
        return testBaseTaskDTO;
    }

    public TestBaseTask mapToEntity(TestBaseTaskDTO dto) {
        return null;
    }

}
