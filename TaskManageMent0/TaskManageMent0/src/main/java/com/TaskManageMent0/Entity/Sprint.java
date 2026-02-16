package com.TaskManageMent0.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table( name = "sprints")
public class Sprint {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;
    private String sprintName ;
    private LocalDateTime startDate ;
    private LocalDateTime endDate ;

    public Long getId() {
        return id;
    }

    public String getSprintName() {
        return sprintName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }




}
