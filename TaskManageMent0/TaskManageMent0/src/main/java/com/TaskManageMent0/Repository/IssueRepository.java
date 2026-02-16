package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.Issue;
import com.TaskManageMent0.Enum.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository  extends JpaRepository <Issue, Long >  {

    List<Issue> findByAssigneeEmail(String assigneeEmail);
    List<Issue> findBySprintId(Long sprintId);
    List<Issue> findByIssueStatus(IssueStatus status );
    List<Issue> findByIssueKey(String issueKey);
    List<Issue>findByEpicId(Long epicId) ;

}
