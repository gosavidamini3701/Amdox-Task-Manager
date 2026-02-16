package com.TaskManageMent0.Entity;

import com.TaskManageMent0.Enum.IssueStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "subTasks")
public class SubTask {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id ;

    private Long parentIssueId ;
    private String issueTitle ;
    private IssueStatus issueStatus ;

    public Long getId() {
        return id;
    }

    public Long getParentIssueId() {
        return parentIssueId;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public void setParentIssueId(Long parentIssueId) {
        this.parentIssueId = parentIssueId;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
