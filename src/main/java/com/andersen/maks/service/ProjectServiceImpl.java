package com.andersen.maks.service;

import com.andersen.maks.entities.Developer;
import com.andersen.maks.entities.Project;
import com.andersen.maks.repository.ProjectRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectRepository projectRepository;
    private DeveloperService developer;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, DeveloperService developer){
        super();
        this.projectRepository = projectRepository;
        this.developer = developer;
    }

    @Override
    public boolean addProject(Project project) {
        try {
            projectRepository.save(project);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public void delete(long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project editProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll() {
        return (List<Project>) projectRepository.findAll();
    }
}
