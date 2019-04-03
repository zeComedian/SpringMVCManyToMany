package com.andersen.maks.repository;

import com.andersen.maks.entities.Developer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Integer> {
    Set<Developer> findByFirstName(String name);

}
