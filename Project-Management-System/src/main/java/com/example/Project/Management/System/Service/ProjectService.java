package com.example.Project.Management.System.service;
import com.example.Project.Management.System.dto.projectDto;

import java.util.List;

public interface projectService {

    projectDto getproject(Integer id);

    projectDto addproject(projectDto project);

   List<projectDto> getallproject();
}
