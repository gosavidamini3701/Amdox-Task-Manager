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

    public UserProfileUpdateDTO userProfileUpdate(UserProfileUpdateDTO updateProfile) {

        UserProfileUpdate existingProfile =
                userProfileUpdateRepo.findByUserOfficialEmail(updateProfile.userOfficialEmail)
                        .orElseThrow(() ->
                                new RuntimeException("Profile NOT found: " + updateProfile.userOfficialEmail)
                        );

        existingProfile.setUserName(updateProfile.userName);
        existingProfile.setDepartment(updateProfile.department);
        existingProfile.setDesignation(updateProfile.designation);
        existingProfile.setOrganisationName(updateProfile.organisationName);
        existingProfile.setActive(updateProfile.active);

        userProfileUpdateRepo.save(existingProfile);

        return toDTO(existingProfile);
    }


    public List<UserProfileUpdateDTO>getAllProfile(){
        return  userProfileUpdateRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList()) ;
    }



    public UserProfileUpdateDTO getProfileByUserEmail( String userOfficialEmail )
    {
        System.out.println(userOfficialEmail);
        UserProfileUpdate userUpdate =
                userProfileUpdateRepo.findByUserOfficialEmail(userOfficialEmail)
                        .orElseThrow(() -> new RuntimeException("User not Found!"));
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
