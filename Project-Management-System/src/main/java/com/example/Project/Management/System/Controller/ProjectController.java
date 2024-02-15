package com.example.Project.Management.System.Controller;

import com.example.Project.Management.System.CustomException.ProjectNotfoundException;
import com.example.Project.Management.System.Dto.ProjectDto;
import com.example.Project.Management.System.Entity.Project;
import com.example.Project.Management.System.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Project")
public class ProjectController {
    @Autowired
    private ProjectService projectservice;

    @GetMapping("/getproject/{id}")
    public ResponseEntity<?> getproject(@PathVariable Integer id) {
        try {
            ProjectDto project = projectservice.getproject(id);
            return ResponseEntity.ok().body(project);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping("/getallproject")
    public ResponseEntity<?> getallproject() {
        try {
           List<ProjectDto> project = projectservice.getallproject();
            return ResponseEntity.ok().body(project);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PostMapping("/addproject")
   public ResponseEntity<?>addproject(@RequestBody ProjectDto project){
try{
    ProjectDto projectdto=projectservice.addproject(project);
    return ResponseEntity.ok().body(projectdto+" "+"-"+"project added successfully");
    }catch (Exception ex){
    return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(ex.getMessage());
    }
    }
}

