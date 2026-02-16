package com.TaskManageMent0.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table( name = "issue_comments")
public class IssueComment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    private Long issueId ;

    private String authorEmail ;



    @Column( columnDefinition =  "TEXT" )
    private String body ;

    private LocalDateTime createdAt = LocalDateTime.now() ;


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getBody() {
        return body;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public Long getIssueId() {
        return issueId;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    
}
