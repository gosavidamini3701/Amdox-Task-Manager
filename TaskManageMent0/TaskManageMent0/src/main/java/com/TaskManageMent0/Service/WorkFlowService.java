package com.TaskManageMent0.Service;


import com.TaskManageMent0.Entity.WorkFlow;
import com.TaskManageMent0.Entity.WorkFlowTransaction;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.Role;

import com.TaskManageMent0.Repository.WorkFlowRepository;
import com.TaskManageMent0.Repository.WorkFlowTransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class WorkFlowService {

    private final WorkFlowRepository workFlowRepo;
    private final WorkFlowTransactionRepository transactionRepo;

    @Transactional
    public WorkFlow createWorkFlow(WorkFlow wf) {

        if (wf.getTransactions() != null) {
            for (WorkFlowTransaction t : wf.getTransactions()) {
                t.setWorkFlow(wf);
            }
        }

        return workFlowRepo.save(wf);
    }

    public List<WorkFlow> getAllWorkFlowList() {
        return workFlowRepo.findAll();
    }

    public WorkFlow getById(Long id) {
        return workFlowRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkFlow not found"));
    }

    @Transactional
    public WorkFlow updateWorkFlow(Long id, WorkFlow update) {

        WorkFlow wf = getById(id);

        wf.setWorkFlowName(update.getWorkFlowName());
        wf.setDescription(update.getDescription());

        wf.getTransactions().clear();

        if (update.getTransactions() != null) {
            for (WorkFlowTransaction t : update.getTransactions()) {
                t.setWorkFlow(wf);
                wf.getTransactions().add(t);
            }
        }

        return workFlowRepo.save(wf);
    }

    @Transactional
    public void deleteWorkFlow(Long id) {
        workFlowRepo.deleteById(id);
    }

    public List<WorkFlowTransaction> allowedTransactions(Long workFlowId, IssueStatus fromStatus) {
        return transactionRepo.findByWorkFlowIdAndFromStatus(workFlowId, fromStatus);
    }

    public boolean isTransactionsAllowed(Long workFlowId,
                                         IssueStatus fromStatus,
                                         IssueStatus toStatus,
                                         Set<Role> userRoles) {

        List<WorkFlowTransaction> transactions =
                transactionRepo.findByWorkFlowIdAndFromStatus(workFlowId, fromStatus);

        for (WorkFlowTransaction t : transactions) {

            if (!t.getToStatus().equals(toStatus)) {
                continue;
            }

            if (t.getAllowedRoles() == null || t.getAllowedRoles().isEmpty()) {
                return true;
            }

            for (Role role : userRoles) {
                if (t.getAllowedRoles().contains(role)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Optional<WorkFlow> findByName(String workFlowName) {
        return workFlowRepo.findByWorkFlowName(workFlowName);
    }
}