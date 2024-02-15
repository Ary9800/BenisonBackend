package com.example.Project.Management.System.ServiceImpl;

import com.example.Project.Management.System.CustomException.ProjectNotfoundException;
import com.example.Project.Management.System.Dto.ProjectDto;
import com.example.Project.Management.System.Entity.Project;
import com.example.Project.Management.System.Repositories.ProjectRepository;
import com.example.Project.Management.System.Service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectrepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProjectDto getproject(Integer id) {
Project project=projectrepo.findById(id).orElseThrow(()->new ProjectNotfoundException("no project exist with this id"));

return modelMapper.map(project,ProjectDto.class);

    }

    @Override
    public ProjectDto addproject(ProjectDto project) {
        Project project1=modelMapper.map(project,Project.class);
        if(projectrepo.existsByName(project1.getName())){
            throw  new ProjectNotfoundException("project already exists");
        }
      Project projectsaved= projectrepo.save(project1);
        return modelMapper.map(projectsaved,ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getallproject() {
       List<Project> project=projectrepo.findAll();
       if(!project.isEmpty()){
       return project.stream().map(project1->modelMapper.map(project1,ProjectDto.class)).collect(Collectors.toList());
    }
       throw new ProjectNotfoundException("no project found");
}}
