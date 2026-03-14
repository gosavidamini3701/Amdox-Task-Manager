package com.TaskManageMent0.Entity;



import com.TaskManageMent0.Enum.IssueStatus;
import com.TaskManageMent0.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "workflow_transactions",
        indexes = @Index(name = "idx_wf_from_to", columnList = "workflow_id,from_status,to_status")
)
public class WorkFlowTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="workflow_id", nullable=false)
    @JsonIgnore
    private WorkFlow workFlow;

    @Enumerated(EnumType.STRING)
    @Column(name="from_status", nullable=false)
    private IssueStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name="to_status", nullable=false)
    private IssueStatus toStatus;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name="workflow_allowed_roles",
            joinColumns=@JoinColumn(name="transaction_id")
    )
    @Column(name="role")
    private Set<Role> allowedRoles = new HashSet<>();
}