package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.UserProfileUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileUpdateRepository extends JpaRepository<UserProfileUpdate ,Long > {


    Optional<UserProfileUpdate> findByOfficialEmail(String userOfficialEmail);


}
