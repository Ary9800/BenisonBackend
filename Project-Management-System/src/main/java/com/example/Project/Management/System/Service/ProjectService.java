package com.example.Project.Management.System.Service;
import com.example.Project.Management.System.Dto.ProjectDto;
import com.example.Project.Management.System.Entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto getproject(Integer id);

    ProjectDto addproject(ProjectDto project);

   List<ProjectDto> getallproject();
}
