package com.example.Project.Management.System;

import com.example.Project.Management.System.Controller.ProjectController;
import com.example.Project.Management.System.CustomException.ProjectNotfoundException;
import com.example.Project.Management.System.Dto.ProjectDto;
import com.example.Project.Management.System.Entity.Project;
import com.example.Project.Management.System.Repositories.ProjectRepository;
import com.example.Project.Management.System.Service.ProjectService;
import com.example.Project.Management.System.ServiceImpl.ProjectServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.Optional;



@ExtendWith(MockitoExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProjectControllerTest {
    @Autowired
    private ProjectRepository projectrepo;
    @Mock
    private ProjectServiceImpl projectservice;
    @InjectMocks
    private ProjectController projectcontroller;
    @Autowired
    private ModelMapper modelMapper;


private Project project;

    @Test
    public void testgetproject(){
        LocalDate dateOfBirth = LocalDate.of(1997, 6, 21);
         project = new Project("shubham",dateOfBirth);
        projectrepo.save(project);
        ProjectDto projectdto=modelMapper.map(project,ProjectDto.class);
        when(projectservice.getproject(project.getId())).thenReturn(projectdto);
        ResponseEntity<?>responseEntity=projectcontroller.getproject(project.getId());
        verify(projectservice, times(1)).getproject(project.getId());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(projectdto, responseEntity.getBody());
        assertEquals(Optional.of(project),projectrepo.findById(project.getId()));
    }



    @Test
    public void testAddProject_Success() {
        ProjectDto inputProjectDto = new ProjectDto(6,"aryan",LocalDate.of(2020,01,04));
        when(projectservice.addproject(any(ProjectDto.class))).thenReturn((inputProjectDto));
        ResponseEntity<?> responseEntity = projectcontroller.addproject(inputProjectDto);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().toString().contains("project added successfully"));
        String expectedResponseBody = inputProjectDto +" "+"-"+"project added successfully";
        assertEquals(expectedResponseBody, responseEntity.getBody());



    }

}
