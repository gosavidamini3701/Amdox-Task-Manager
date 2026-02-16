package com.TaskManageMent0.Repository;



import com.TaskManageMent0.Entity.Workflow;


import com.TaskManageMent0.Entity.WorkflowTransaction;
import com.TaskManageMent0.Enum.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkFlowTransactionRepository extends JpaRepository<WorkflowTransaction, Long> {
    List<WorkflowTransaction> findByWorkflowId(Workflow workflowId);
    List<WorkflowTransaction> findByWorkflowIdAndFromStatus(Workflow workflowId, IssueStatus fromStatus);
}