package com.example.Project.Management.System.controller;

import com.example.Project.Management.System.customException.projectNotfoundException;
import com.example.Project.Management.System.dto.projectDto;
import com.example.Project.Management.System.service.projectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class projectController {
    @Autowired
    private projectService projectservice;

    @GetMapping("/projects/{project_id}")
    public ResponseEntity<?> getproject(@PathVariable Integer project_id) {
        try {
            projectDto project = projectservice.getproject(project_id);
            return ResponseEntity.ok().body(project);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @GetMapping("/projects")
    public ResponseEntity<?> getallproject() {
        try {
           List<projectDto> project = projectservice.getallproject();
            return ResponseEntity.ok().body(project);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PostMapping("/projects")
   public ResponseEntity<?>addproject(@RequestBody projectDto project){
try{
    projectDto projectdto=projectservice.addproject(project);
    return ResponseEntity.ok().body(projectdto+" "+"-"+"project added successfully");
    }catch (projectNotfoundException ex){
    return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(ex.getMessage());
    }
catch (Exception ex){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an error occured"+ex.getMessage());
}
    }
}

