package com.TaskManageMent0.Repository;



import com.TaskManageMent0.Entity.WorkFlowTransaction;

import com.TaskManageMent0.Enum.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkFlowTransactionRepository extends JpaRepository<WorkFlowTransaction, Long> {
    List<WorkFlowTransaction>findByWorkFlowId(Long workflowId);
    List<WorkFlowTransaction>findByWorkFlowIdAndFromStatus(Long workflowId, IssueStatus fromStatus);
}