package com.andersen.maks.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "HIBERNATE_PROJECTS")
public class Project {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "COMPANY")
    private String company;
    @ManyToOne(optional = false)
    @JoinColumn(name = "DEVELOPER_ID")
    Developer developer;


    public Project() {
    }

    public Project(String projectName, String company) {
        this.projectName = projectName;
        this.company = company;
    }

    public Project(String projectName, String company, Developer developer) {
        this.projectName = projectName;
        this.company = company;
        this.developer = developer;
    }

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

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setCompany(String company) {
        this.company = company;
    }



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

    public int hashCode() {
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
