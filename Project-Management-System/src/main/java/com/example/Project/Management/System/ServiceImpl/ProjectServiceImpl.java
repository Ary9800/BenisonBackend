package com.example.Project.Management.System.serviceImpl;

import com.example.Project.Management.System.customException.projectNotfoundException;
import com.example.Project.Management.System.dto.projectDto;
import com.example.Project.Management.System.entity.Project;
import com.example.Project.Management.System.repositories.projectRepository;
import com.example.Project.Management.System.service.projectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class projectServiceImpl implements projectService {
    @Autowired
    private projectRepository projectrepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public projectDto getproject(Integer id) {
Project project=projectrepo.findById(id).orElseThrow(()->new projectNotfoundException("no project exist with this id"));

return modelMapper.map(project, projectDto.class);

    }

    @Override
    public projectDto addproject(projectDto project) {
        try{
        Project project1=modelMapper.map(project,Project.class);
        if(projectrepo.existsByName(project1.getName())){
            throw  new projectNotfoundException("project already exists");
        }
      Project projectsaved= projectrepo.save(project1);
        return modelMapper.map(projectsaved, projectDto.class);
    }catch (Exception e){
            throw e;
        }}


    @Override
    public List<projectDto> getallproject() {
       List<Project> project=projectrepo.findAll();
       if(!project.isEmpty()){
       return project.stream().map(project1->modelMapper.map(project1, projectDto.class)).collect(Collectors.toList());
    }
       throw new projectNotfoundException("no project found");
}}
