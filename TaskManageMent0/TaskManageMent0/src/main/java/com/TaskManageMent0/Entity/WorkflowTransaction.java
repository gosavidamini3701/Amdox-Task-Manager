package com.TaskManageMent0.Entity;


import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name ="workFlow_Transactions",
        indexes = {
                @Index(
                        name = "idx_wf_from_to",
                        columnList = "workflow_id,from_status,to_status"
                )
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkflowTransaction {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long TransactionId;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="workflow_id",nullable=false )
    private Workflow workflowId;

    @Column(nullable=false)
    private IssueStatus fromStatus ;

    @Column(nullable=false)
    private IssueStatus toStatus ;


    private String name ;

    private Role allowedRole ;



}