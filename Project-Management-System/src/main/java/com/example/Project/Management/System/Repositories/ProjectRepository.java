package com.example.Project.Management.System.repositories;

import com.example.Project.Management.System.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface projectRepository extends JpaRepository<Project,Integer> {

    boolean existsByName(String name);
}
