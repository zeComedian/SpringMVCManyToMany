package com.andersen.maks.entities;

import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HIBERNATE_PROJECTS")
public class Project {


    private Set<Developer> developers;

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "COMPANY")
    private String company;

    @Access(AccessType.PROPERTY)
    @ManyToMany(targetEntity = Developer.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "HIBERNATE_DEV_PROJECTS", joinColumns = {
            @JoinColumn(name = "PROJECT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "DEVELOPER_ID", referencedColumnName = "id")})
    public Set<Developer> getDevelopers()
    {
        Hibernate.initialize(developers);
        return developers;
    }


    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    //    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
//    Developer developer;

    /**
     * Constructors
     */
    public Project() {
    }

    public Project(String projectName, String companyName) {
        this.projectName = projectName;
        this.company = companyName;
    }


    /**
     * Getters and Setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Methods equals and hashCode for comparing objects
     */

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }

        Project object2 = (Project) object;
        if ((this.id == object2.getId()) && (this.projectName == object2.getProjectName()) && (this.company == object2.getCompany())) {
            return true;
        }
        return false;
    }

    public int hasCode() {
        int code = 0;
        code = (id + projectName + company).hashCode();
        return code;
    }

    @Override
    public String toString() {
        return "Project:\n" +
                "id: " + id +
                "\nProject Name: " + projectName +
                "\nCompany Name: " + company + "\n";
    }
}
