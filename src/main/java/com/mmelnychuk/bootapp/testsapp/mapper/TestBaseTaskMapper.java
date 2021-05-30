package com.mmelnychuk.bootapp.testsapp.mapper;

import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestBaseTaskOptionDTO;
import com.mmelnychuk.bootapp.testsapp.model.TaskType;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTask;
import com.mmelnychuk.bootapp.testsapp.model.TestBaseTaskOption;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestBaseTaskMapper implements Mapper {

    public TestBaseTaskDTO mapToDTO(TestBaseTask testBaseTask) {
        TestBaseTaskDTO testBaseTaskDTO = new TestBaseTaskDTO();
        testBaseTaskDTO.setId(testBaseTask.getId());
        testBaseTaskDTO.setQuestion(testBaseTask.getQuestion());
        testBaseTaskDTO.setType(testBaseTask.getType().getType().name());
        testBaseTaskDTO.setMark(testBaseTask.getMark());
        List<TestBaseTaskOption> taskOptions = testBaseTask.getTestBaseTaskOptions();
        List<TestBaseTaskOption> correctOptions = taskOptions.stream()
                .filter(TestBaseTaskOption::getCorrect).collect(Collectors.toList());

        if(!testBaseTask.getType().getType().equals(TaskType.MULTIPLE_CHOICE)) {
            testBaseTaskDTO.setCorrectOption(correctOptions.get(0).getOptionValue());
        }else {
            StringBuilder stringBuilder = new StringBuilder("");
            for(TestBaseTaskOption option : correctOptions) {
                stringBuilder.append(option.getOptionValue()).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            testBaseTaskDTO.setCorrectOption(stringBuilder.toString());
        }

        if (!testBaseTask.getType().getType().equals(TaskType.SHORT_ANSWER)) {
            List<TestBaseTaskOptionDTO> options = taskOptions.stream()
                    .map(option -> new TestBaseTaskOptionDTO(option.getId(), option.getOptionValue()))
                    .collect(Collectors.toList());
            testBaseTaskDTO.setOptions(options);
        }
        return testBaseTaskDTO;
    }
}
