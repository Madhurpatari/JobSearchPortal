package com.Geekster.JobSearchPortal.Model;

import com.Geekster.JobSearchPortal.Model.Enum.JobType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title must be less than or equal to 100 characters")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Location is mandatory")
    @Size(max = 50, message = "Location must be less than or equal to 50 characters")
    private String location;


    @NotNull(message = "Salary is mandatory")
    @PositiveOrZero(message = "Salary must be positive or zero")
    private Double salary;

    @NotBlank(message = "Company name is mandatory")
    @Column(unique = true)
    @Size(max = 100, message = "Company name must be less than or equal to 100 characters")
    private String companyName;

    @NotBlank(message = "Employer name is mandatory")
    @Size(min = 2, max = 30)
    private String employerName;

    @NotNull(message = "Job type is mandatory")
    @Enumerated(EnumType.STRING)
    private JobType jobType;
}
