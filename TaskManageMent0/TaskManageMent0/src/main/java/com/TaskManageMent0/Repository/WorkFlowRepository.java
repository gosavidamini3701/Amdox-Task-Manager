package com.TaskManageMent0.Repository;


import com.TaskManageMent0.Entity.WorkFlow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkFlowRepository extends JpaRepository<WorkFlow, Long> {

    Optional<WorkFlow>findByWorkFlowName(String workFlowName);

}