package com.TaskManageMent0.Controller;

import com.TaskManageMent0.DTO.UserProfileUpdateDTO;
import com.TaskManageMent0.Service.UserProfileUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/update_profile")
@RequiredArgsConstructor
public class UserProfileUpdateController {

    @Autowired
    private UserProfileUpdateService  userProfileUpdateService ;

    @PutMapping("/updateProfile")
    public ResponseEntity<UserProfileUpdateDTO> updateProfile(@RequestBody UserProfileUpdateDTO UserUpdate ){

        return ResponseEntity.ok(userProfileUpdateService.userProfileUpdate(UserUpdate)) ;


    }

    @GetMapping("/allProfile")
    public ResponseEntity<List<UserProfileUpdateDTO>> getAllProfile( ){

        return ResponseEntity.ok(userProfileUpdateService.getAllProfile());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserProfileUpdateDTO>getProfileByEmail( @PathVariable String userOfficialEmail )
    {
        return ResponseEntity.ok(userProfileUpdateService.getProfileByUserEmail(userOfficialEmail)) ;
    }





}
