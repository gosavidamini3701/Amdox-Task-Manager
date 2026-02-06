package com.TaskManageMent0.Service;

import com.TaskManageMent0.DTO.UserProfileUpdateDTO;
import com.TaskManageMent0.Entity.UserProfileUpdate;
import com.TaskManageMent0.Repository.UserProfileUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.* ;
import java.util.stream.Collectors;

@Service
public class UserProfileUpdateService {

    @Autowired
    private UserProfileUpdateRepository  userProfileUpdateRepo ;

    public UserProfileUpdateDTO userProfileUpdate(UserProfileUpdateDTO  updateProfile )
    {
        if(userProfileUpdateRepo.findByOfficialEmail( updateProfile.userOfficialEmail).isPresent())
        {
            throw new RuntimeException("Profile already Exists "+ updateProfile.userOfficialEmail);
        }

        UserProfileUpdate profileUpdate = new UserProfileUpdate() ;

        profileUpdate.setUserName(updateProfile.userName);
        profileUpdate.setUserOfficialEmail(updateProfile.userOfficialEmail);
        profileUpdate.setDepartment(updateProfile.department);

        profileUpdate.setDesignation(updateProfile.designation);
        profileUpdate.setOrganisationName(updateProfile.organisationName);
        profileUpdate.setActive(true);


        userProfileUpdateRepo.save(profileUpdate);
        return  toDTO(profileUpdate);

    }


    public List<UserProfileUpdateDTO>getAllProfile(){
        return  userProfileUpdateRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList()) ;
    }



    public UserProfileUpdateDTO getProfileByUserEmail( String userOfficialEmail )
    {
        UserProfileUpdate userUpdate  = userProfileUpdateRepo.findByOfficialEmail(userOfficialEmail).orElse(()-> throw new RuntimeException("User not found !"));
        return toDTO(userUpdate);
    }


    private UserProfileUpdateDTO toDTO(UserProfileUpdate profile) {

        UserProfileUpdateDTO dto = new UserProfileUpdateDTO();
         dto.setUserName(profile.getUserName());
         dto.setUserOfficialEmail(profile.getUserOfficialEmail());
         dto.setDesignation(profile.getDesignation());
         dto.setDepartment(profile.getDepartment());
         dto.setOrganisationName(profile.getOrganisationName());
         dto.setActive(profile.isActive());

         return dto ;


    }

}
