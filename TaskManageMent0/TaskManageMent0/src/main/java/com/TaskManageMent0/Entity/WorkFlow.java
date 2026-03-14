package com.TaskManageMent0.Entity;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "work_flows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_flow_name", unique = true, nullable = false)
    private String workFlowName;

    @Column(length = 1000)
    private String description;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "workFlow",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkFlowTransaction> transactions = new ArrayList<>();

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    // Helper method to maintain bidirectional relationship
    public void addTransaction(WorkFlowTransaction transaction) {
        transactions.add(transaction);
        transaction.setWorkFlow(this);
    }
}