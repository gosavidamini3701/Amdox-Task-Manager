package com.TaskManageMent0.Entity;

import com.TaskManageMent0.Enum.SprintStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="sprints")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;
    private SprintStatus sprintStatus;
    private String sprintName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt=LocalDateTime.now();
    private String sprintDescription;
}