package com.andersen.maks.service;

import com.andersen.maks.entities.Developer;

import java.util.List;
import java.util.Set;

public interface DeveloperService {

    boolean addDeveloper(Developer developer);
    boolean delete(int id);
    Developer editDeveloper(Developer developer);
    List<Developer> getAll();
    Developer getDeveloperById(int id);
    Set<Developer> getByName(String name);

}

