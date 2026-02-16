package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpicRepository extends JpaRepository<Epic, Long > {
}
