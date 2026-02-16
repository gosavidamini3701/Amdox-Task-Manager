package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository <SubTask, Long > {

}
