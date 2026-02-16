package com.TaskManageMent0.Service;


import com.TaskManageMent0.Entity.Workflow;
import com.TaskManageMent0.Entity.WorkflowTransaction;
import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Repository.WorkFlowRepository;
import com.TaskManageMent0.Repository.WorkFlowTransactionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowService {

    @Autowired
    private WorkFlowRepository workFlowRepo ;


    @Autowired
    private WorkFlowTransactionRepository workFlowTransactionRepo ;


    @Autowired
    private WorkFlowTransactionRepository transactionRepo ;


    @Transactional
    public Workflow createWorkFlow(Workflow workFlow) {

        if ( workFlow.getTransactions() != null ) {

            for ( WorkflowTransaction workFlowTransaction  :  workFlow.getTransactions() ) {

                workFlowTransaction.setWorkflowId( workFlow );

            }
        }

        return workFlowRepo.save( workFlow ) ;
    }



    public List<Workflow> getAllWorkFlow() {

        return workFlowRepo.findAll() ;

    }


    public Workflow getWorkFlowById(Long workFlowId) {

        return workFlowRepo.findById( workFlowId)
                .orElseThrow(() -> new RuntimeException( "Work Flow Not Found" ) ) ;


    }



    @Transactional
    public Workflow updateWorkFlow(Long id , Workflow workFlow ) {

        Workflow storedWorkFlow  = getWorkFlowById( id ) ;

        storedWorkFlow.setWorkflowName( workFlow.getWorkflowName() ) ;

        storedWorkFlow.setDescription( workFlow.getDescription() ) ;

        storedWorkFlow.setWorkflowId( workFlow.getWorkflowId() ) ;

        storedWorkFlow.getTransactions().clear();

        if ( workFlow.getTransactions() != null ) {

            for ( WorkflowTransaction workFlowTransaction : workFlow.getTransactions() ) {

                workFlowTransaction.setWorkflowId( workFlow ) ;

                storedWorkFlow.getTransactions().add( workFlowTransaction ) ;

            }
        }

        return workFlowRepo.save( storedWorkFlow ) ;

    }

    private Workflow getById(Long id) {

        return workFlowRepo.findById( id ).orElseThrow( () -> new RuntimeException( "Work Flow Not Found" ) ) ;
    }

    public void deleteWorkFlow( Long id ) {

        workFlowRepo.deleteById( id );

    }

    public List<WorkflowTransaction> allowedTransactions(Workflow workflow , IssueStatus status ) {

        if ( !workFlowRepo.findById( workflow.getWorkflowId() ).isPresent() ) {

            throw new RuntimeException( "Work Flow Not Found" ) ;

        }
        return transactionRepo.findByWorkflowIdAndFromStatus( workflow , status ) ;

    }

}