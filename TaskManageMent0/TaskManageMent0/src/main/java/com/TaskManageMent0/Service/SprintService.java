package com.TaskManageMent0.Service;



import com.TaskManageMent0.Entity.Issue;
import com.TaskManageMent0.Entity.Sprint;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.SprintStatus;
import com.TaskManageMent0.Repository.IssueRepository;
import com.TaskManageMent0.Repository.SprintRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SprintService {

    @Autowired
    private SprintRepository sprintRepo;

    @Autowired
    private IssueRepository  issueRepo;

    public Sprint createSprint(Sprint sprint) {
        sprint.setSprintStatus(SprintStatus.PLANED);
        return sprintRepo.save(sprint);
    }

    @Transactional
    public Issue assignIssueToSprint(Long issueId, Long sprintId) {
        Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(()->new RuntimeException("Sprint not found"));
        Issue issue=issueRepo.findById(issueId).orElseThrow(()->new RuntimeException("Issue not found"));

        if(sprint.getSprintStatus().equals(SprintStatus.COMPLETE)){
            throw new RuntimeException("can't add the task to completed Sprint");
        }

        issue.setSprintId(sprintId);
        return issueRepo.save(issue);
    }

    @Transactional
    public Sprint startSprint(Long sprintId) {
        Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(()->new RuntimeException("Sprint not found"));

        if(!sprint.getSprintStatus().equals(SprintStatus.PLANED)){
            throw new RuntimeException("sprint status is not started yet");
        }

        sprint.setSprintStatus(SprintStatus.ACTIVE);

        if(sprint.getStartDate()==null){
            sprint.setStartDate(LocalDate.now());
        }

        return sprintRepo.save(sprint);
    }

    @Transactional
    public Sprint closeSprint(Long sprintId) {
        Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(()->new RuntimeException("Sprint not found"));
        sprint.setSprintStatus(SprintStatus.COMPLETE);

        if(sprint.getEndDate()==null){
            sprint.setEndDate(LocalDate.now());
        }

        List<Issue> issues=issueRepo.findBySprintId(sprintId);
        for(Issue issue:issues){
            if(issue.getIssueStatus()!= IssueStatus.RESOLVED){
                issue.setSprintId(null);
                issueRepo.save(issue);
            }
        }
        return sprintRepo.save(sprint);
    }

    public Map<String,Object> getBurnDownData(Long sprintId){
        Sprint sprint = sprintRepo.findById(sprintId).orElseThrow(()->new RuntimeException("Sprint not found"));

        LocalDate start=sprint.getStartDate();
        LocalDate end=sprint.getEndDate()!=null?sprint.getEndDate():LocalDate.now();

        List<Issue> issues=issueRepo.findBySprintId(sprintId);

        int totalIssues=issues.size();

        Map<String,Object> chart=new LinkedHashMap<>();

        LocalDate cursor=start;

        while(!cursor.isAfter(end)){
            int completedTask=(int) issues.stream().filter((i)->i.getIssueStatus()==IssueStatus.RESOLVED).count();

            chart.put(cursor.toString(),totalIssues-completedTask);
            cursor=cursor.plusDays(1);
        }

        Map<String,Object> response=new HashMap<>();
        response.put("SprintId",sprintId);
        response.put("StartDate",start);
        response.put("EndDate",end);
        response.put("BurnDownData",chart);

        return response;

    }
}