package com.andersen.maks.service;

import com.andersen.maks.entities.Project;

import java.util.List;

public interface ProjectService {

    boolean addProject(Project project);
    void delete(int id);
    Project editProject(Project project);
    List<Project> getAll();
    Project getProjectById(int id);


}
