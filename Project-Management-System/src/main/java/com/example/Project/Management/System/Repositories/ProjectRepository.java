package com.example.Project.Management.System.Repositories;

import com.example.Project.Management.System.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

    boolean existsByName(String name);
}
