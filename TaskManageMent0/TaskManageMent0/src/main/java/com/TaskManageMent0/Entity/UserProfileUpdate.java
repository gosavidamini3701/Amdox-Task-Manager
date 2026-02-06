package com.TaskManageMent0.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "user_profile_update")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserProfileUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String userOfficialEmail;

    private String department;
    private String designation;
    private String organisationName;

    private boolean active = true ;
    private LocalDateTime createdAt = LocalDateTime.now() ;

    public long getId() {
        return id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
