package com.TaskManageMent0.Repository;

import com.TaskManageMent0.Entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository  extends JpaRepository<UserAuth, Long> {


    Optional <UserAuth> findById( Long Id ) ;
    Optional <UserAuth> findByUserOfficialEmail( String userOffilcialEmail ) ;
    Optional <UserAuth> findByResetToken( String resetToken ) ;



}
