package com.TaskManageMent0.Service;

import com.TaskManageMent0.Entity.*;
import com.TaskManageMent0.Enum.IssuePriority;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.IssueType;
import com.TaskManageMent0.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepo ;

    @Autowired
    private IssueCommentRepository issueCommentRepo ;

    @Autowired
    private EpicRepository epicRepo ;

    @Autowired
    private SprintRepository sprintRepo ;

    @Autowired
    private SubTaskRepository  subTaskRepo ;


    private String generateIssueKey(Long id)
    {
        return "PROJ-"+id ;
    }

    @Transactional
    public Issue createIssue(Issue issues )
    {
         if(issues.getIssueType() == null ) issues.setIssueType(IssueType.TASK);

         if(issues.getPriority()== null )issues.setPriority(IssuePriority.MEDIUM);

         issues.setIssueStatus(IssueStatus.OPEN);

         issues.setIssueKey(generateIssueKey(issues.getId()));


         return issueRepo.save(issues) ;


    }

    public Issue getIssueById(Long id )
    {
         return issueRepo.findById(id).orElseThrow(()->new RuntimeException("Issue not found "));


    }

    public List<Issue> getIssueByAssigneeEmail( String assigneeEmail )
    {
         return issueRepo.findByAssigneeEmail(assigneeEmail) ;

    }
    public List <Issue> getIssueBysprintId(Long sprintId ){
        return issueRepo.findBySprintId(sprintId) ;
    }

    public List<Issue>getIssueByEpicId(Long epicId)
    {
           return issueRepo.findByEpicId(epicId);
    }

    @Transactional
    public Issue updateStatus(Long id , IssueStatus status , String performedBy ){

        System.out.println(id+" "+ performedBy + " "+ status  ) ;
        Issue issue = issueRepo.findById(id).orElseThrow(()->new RuntimeException("issue not found ")) ;

        try {

            IssueStatus newStatus = IssueStatus.valueOf(status.toString());
            issue.setIssueStatus(newStatus);

        }catch( Exception e ) {

            throw new RuntimeException("Invalid Status ") ;

        }


        issue.setUpdatedAt(LocalDateTime.now());

        return issueRepo.save(issue) ;


    }

    @Transactional
    public IssueComment addComment( Long issueId ,String authorEmail , String body )
    {
        Issue issue = issueRepo.findById(issueId).orElseThrow(()->new RuntimeException("issue not found ")) ;

        IssueComment comment = new IssueComment() ;

        comment.setIssueId(issueId);
        comment.setAuthorEmail(authorEmail);
        comment.setBody(body);

         return issueCommentRepo.save(comment);


    }

    @Transactional
    public List<Issue> search(Map<String , String> filter ){

        if(filter.containsKey("assigneeEmail")){
            return getIssueByAssigneeEmail(filter.get("assigneeEmail")) ;
        }

        if(filter.containsKey("sprint"))
        {
            Long sprintId = Long.valueOf(filter.get("sprint"));

            return getIssueBysprintId(sprintId);
        }

        if(filter.containsKey("IssueStatus"))
        {
            IssueStatus status = IssueStatus.valueOf( filter.get("IssueStatus").toUpperCase()) ;

            return issueRepo.findByIssueStatus(status );

        }

        return issueRepo.findAll();


    }

    @Transactional
    public Sprint createSprint( Sprint sprint )
    {
         return sprintRepo.save(sprint);
    }

    @Transactional
    public Epic createEpic( Epic epic ){
         return epicRepo.save(epic);
    }

    @Transactional
    public SubTask createSubTask(SubTask subTask)
    {
        return subTaskRepo.save(subTask) ;
    }









}
