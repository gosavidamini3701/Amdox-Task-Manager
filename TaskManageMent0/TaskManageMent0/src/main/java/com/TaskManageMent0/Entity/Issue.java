package com.TaskManageMent0.Entity;

import com.TaskManageMent0.Enum.IssuePriority;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.IssueType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Issue {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    private String issueTitle ;
    private String issueKey ;

    @Column( length = 2000 )
    private String description ;

    @Enumerated( EnumType.STRING )
    private IssueType issueType ;

    @Enumerated ( EnumType.STRING )
    private IssueStatus issueStatus ;

    @Enumerated ( EnumType.STRING )
    private IssuePriority priority ;

    private String assigneeEmail ;
    private String reporterEmail ;


   private Long epicId ;
   private Long sprintId ;

   @CreationTimestamp
   @Column(updatable = false)
   private LocalDateTime   createdAt = LocalDateTime.now() ;
   @UpdateTimestamp
   private LocalDateTime updatedAt = LocalDateTime.now() ;
   private  LocalDateTime dueDate ;

    public Long getId() {
        return id;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public String getDescription() {
        return description;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public IssuePriority getPriority() {
        return priority;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public Long getEpicId() {
        return epicId;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIssueType(IssueType issueType) {
        this.issueType = issueType;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public void setPriority(IssuePriority priority) {
        this.priority = priority;
    }

    public void setAssigneeEmail(String assigneeEmail) {
        this.assigneeEmail = assigneeEmail;
    }

    public void setReporterEmail(String reporterEmail) {
        this.reporterEmail = reporterEmail;
    }

    public void setEpicId(Long epicId) {
        this.epicId = epicId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
