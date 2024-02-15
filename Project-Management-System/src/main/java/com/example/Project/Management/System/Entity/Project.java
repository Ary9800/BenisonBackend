package com.example.Project.Management.System.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Project")
public class Project extends BaseEntity {
    @Column(name="name", length=50,nullable = false)
    private String name;
    @Column(name="Start_date",nullable = false)
    private LocalDate start_date;

}
