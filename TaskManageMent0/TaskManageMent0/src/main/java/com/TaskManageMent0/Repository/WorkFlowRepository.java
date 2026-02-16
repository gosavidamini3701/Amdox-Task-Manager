package com.TaskManageMent0.Repository;


import com.TaskManageMent0.Entity.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkFlowRepository extends JpaRepository<Workflow, Long> {

    Optional<Workflow> findByWorkflowName(String workflowName);

}