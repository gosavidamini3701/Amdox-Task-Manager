package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.IssueComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueCommentRepository extends JpaRepository<IssueComment , Long > {

    List<IssueComment>findByIssueIdIsOrderByCreatedAt( Long issueId ) ;



}
