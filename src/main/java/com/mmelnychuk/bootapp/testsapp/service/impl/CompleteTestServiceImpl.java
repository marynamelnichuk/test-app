package com.mmelnychuk.bootapp.testsapp.service.impl;

import com.mmelnychuk.bootapp.testsapp.dto.create.TestResultCreateDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestResultDTO;
import com.mmelnychuk.bootapp.testsapp.dto.read.TestTaskDTO;
import com.mmelnychuk.bootapp.testsapp.exceptions.NotFoundException;
import com.mmelnychuk.bootapp.testsapp.mapper.TestBaseTaskMapper;
import com.mmelnychuk.bootapp.testsapp.model.*;
import com.mmelnychuk.bootapp.testsapp.repository.TestAssignmentRepository;
import com.mmelnychuk.bootapp.testsapp.repository.TestResultRepository;
import com.mmelnychuk.bootapp.testsapp.repository.TestResultTaskRepository;
import com.mmelnychuk.bootapp.testsapp.service.CompleteTestService;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.ComparableComparator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompleteTestServiceImpl implements CompleteTestService {

    private final TestAssignmentRepository assignmentRepository;
    private final TestBaseTaskMapper testBaseTaskMapper;
    private final TestResultRepository testResultRepository;
    private final TestResultTaskRepository testResultTaskRepository;

    public CompleteTestServiceImpl(TestAssignmentRepository assignmentRepository,
                                   TestBaseTaskMapper testBaseTaskMapper,
                                   TestResultRepository testResultRepository,
                                   TestResultTaskRepository testResultTaskRepository) {
        this.assignmentRepository = assignmentRepository;
        this.testBaseTaskMapper = testBaseTaskMapper;
        this.testResultRepository = testResultRepository;
        this.testResultTaskRepository = testResultTaskRepository;
    }

    @Override
    public List<TestTaskDTO> getTestTaskToComplete(Integer assigmentId) throws NotFoundException {
        TestAssignment assignment = assignmentRepository.findById(assigmentId)
                .orElseThrow(() -> new NotFoundException(""));
        List<TestVariant> testVariants = assignment.getVariants();
        testVariants.sort(new ComparableComparator<>());
        List<TestTask> testTasks = new ArrayList<>();
        for(TestVariant testVariant : testVariants) {
            testTasks.add(testVariant.getTestTask());
        }
        assignment.setStatus(AssignmentStatus.STARTED);
        assignmentRepository.save(assignment);

        List<TestTaskDTO> dtos = new ArrayList<>();
        for(TestTask testTask : testTasks) {
            TestTaskDTO dto = new TestTaskDTO();
            dto.setId(testTask.getId());
            dto.setMark(testTask.getMark());
            dto.setTestBaseTaskDTO(testBaseTaskMapper.mapToDTO(testTask.getTestBaseTask()));
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public TestResultDTO completeTest(Integer assigmentId, List<TestResultCreateDTO> testResults) throws NotFoundException {
        TestAssignment assignment = assignmentRepository.findById(assigmentId)
                .orElseThrow(() -> new NotFoundException(""));
        Test test = assignment.getTest();
        List<TestTask> testTasks = test.getTestTasks();

        TestResult testResult = new TestResult();
        testResult.setAssignment(assignment);
        testResult.setCompletedDate(LocalDateTime.now());

        Integer estimation = 0;
        List<TestResultTask> testResultTasksToSave = new ArrayList<>();
        for(TestTask testTask : testTasks) {
            TestResultCreateDTO testResultDto = testResults.stream()
                    .filter(el -> el.getTestTaskId().equals(testTask.getId())).findFirst().orElseThrow();
            TestBaseTask testBaseTask = testTask.getTestBaseTask();
            if(testBaseTask.getType().getType().equals(TaskType.MULTIPLE_CHOICE)) {
                System.out.println("MULTIPLE CHOICE " + testTask.getTestBaseTask().getQuestion());
            }else {
                List<TestBaseTaskOption> options = testBaseTask.getTestBaseTaskOptions();
                TestBaseTaskOption correctOption = options.stream()
                        .filter(TestBaseTaskOption::getCorrect).findFirst().orElseThrow();
                Integer responseId = testResultDto.getAnswers().get(0);
                if(correctOption.getId().equals(responseId)) {
                    estimation += testTask.getMark();
                    System.out.println(testTask.getMark());
                    //правильна відповідь
                    System.out.println(testTask.getTestBaseTask().getQuestion());
                }
                TestBaseTaskOption responseOption = options.stream()
                        .filter(el -> el.getId().equals(responseId)).findFirst().orElseThrow();
                TestResultTask testResultTask = new TestResultTask();
                testResultTask.setTestBaseTask(testBaseTask);
                testResultTask.setResponse(responseOption);
                testResultTasksToSave.add(testResultTask);
            }
        }

        testResult.setEstimation(estimation);
        TestResult savedTestResult = testResultRepository.save(testResult);
        for(TestResultTask resultTask : testResultTasksToSave) {
            resultTask.setTestResult(savedTestResult);
        }
        testResultTaskRepository.saveAll(testResultTasksToSave);

        TestResultDTO resultDTO = new TestResultDTO();
        resultDTO.setTestName(test.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = formatter.format(testResult.getCompletedDate());
        resultDTO.setCompletedDate(date);
        resultDTO.setId(testResult.getId());
        resultDTO.setMark(testResult.getEstimation());
        resultDTO.setMaxMark(test.getTotalMark());
        resultDTO.setUserEmail(assignment.getUser().getEmail());
        return resultDTO;
    }

}
