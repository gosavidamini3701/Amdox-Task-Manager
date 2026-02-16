package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long > {
}
