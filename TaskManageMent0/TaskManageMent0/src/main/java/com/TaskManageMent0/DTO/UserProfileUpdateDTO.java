package com.TaskManageMent0.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileUpdateDTO {

    public String userName ;
    public String userOfficialEmail ;
    public String department ;

    public String designation ;
    public String organisationName ;

    public boolean active ;

    public String getUserName() {
        return userName;
    }

    public String getUserOfficialEmail() {
        return userOfficialEmail;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public boolean isActive() {
        return active;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserOfficialEmail(String userOfficialEmail) {
        this.userOfficialEmail = userOfficialEmail;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
