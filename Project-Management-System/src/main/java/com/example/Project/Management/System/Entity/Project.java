package com.example.Project.Management.System.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="project")
public class Project extends baseEntity {
    @Column(name="name", length=50,nullable = false)
    private String name;
    @Column(name="Start_date",nullable = false)
    private LocalDate start_date;

}
