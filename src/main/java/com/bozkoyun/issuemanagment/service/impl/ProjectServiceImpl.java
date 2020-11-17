package com.bozkoyun.issuemanagment.service.impl;

import com.bozkoyun.issuemanagment.dto.ProjectDto;
import com.bozkoyun.issuemanagment.entity.Project;
import com.bozkoyun.issuemanagment.repository.ProjectRepository;
import com.bozkoyun.issuemanagment.service.ProjectService;
import com.bozkoyun.issuemanagment.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ProjectServiceImpl  implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ProjectDto save(ProjectDto project) {

       Project projectCheck=projectRepository.getByProjectCode(project.getProjectCode());

        if(projectCheck!=null)
              throw new IllegalArgumentException("Project Already Exist on System or Database");

        Project p=modelMapper.map(project,Project.class);
       p= projectRepository.save(p);
       project.setId(p.getId());

        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p=projectRepository.getOne(id);
       return modelMapper.map(p,ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data=projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<ProjectDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));



        return respnose;
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);

        return Boolean.TRUE;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {

        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());
        projectRepository.save(projectDb);
        return modelMapper.map(projectDb,ProjectDto.class);
    }
}
