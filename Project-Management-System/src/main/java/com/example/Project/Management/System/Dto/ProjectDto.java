package com.example.Project.Management.System.Dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDto {
    private Integer id;
    private String name;
    private LocalDate start_date;
}
