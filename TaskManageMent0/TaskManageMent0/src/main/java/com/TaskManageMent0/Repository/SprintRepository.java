package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManageMent0.Enum.SprintStatus;


import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint,Long> {

    List<Sprint> findByProjectId(Long projectId);
    List<Sprint> findBySprintStatus(SprintStatus sprintStatus);

}