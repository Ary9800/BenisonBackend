package com.example.Project.Management.System.dto;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class projectDto {
    private Integer id;
    private String name;
    private LocalDate start_date;
}
