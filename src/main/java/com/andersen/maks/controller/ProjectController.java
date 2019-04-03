package com.andersen.maks.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;


import javax.servlet.http.HttpServletResponse;

import com.andersen.maks.entities.Developer;
import com.andersen.maks.entities.Project;
import com.andersen.maks.service.DeveloperService;
import com.andersen.maks.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProjectController {

    private ProjectService projectService;
    private DeveloperService developerService;

    public ProjectController(){

    }

    @Autowired
    public ProjectController(ProjectService projectService, DeveloperService developerService){
        this.projectService = projectService;
        this.developerService = developerService;
    }


    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public ModelAndView displayNewProjectForm(){
        ModelAndView mv = new ModelAndView("addProject");
        mv.addObject("headerMessage", "Add Project Details");
        mv.addObject("project", new Project());
        return mv;
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView saveNewProject(@ModelAttribute Project project, @RequestParam String firstName, BindingResult result){
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");

        if (result.hasErrors()){
            return new ModelAndView("error");
        }
        project.setDevelopers(developerService.getByName(firstName));
        boolean isAdded = projectService.addProject(project);
        System.out.println(project.toString());
        if (isAdded){
            mv.addObject("message", "New Project added");
        }else {
            return new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping(value = "/editProject/{id}", method = RequestMethod.GET)
    public ModelAndView displayEditProjectForm(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("/editProject");
        Project project = projectService.getProjectById(id);
        mv.addObject("headerMessage", "Edit Project Details");
        mv.addObject("project", project);
        return mv;
    }

    @RequestMapping(value = "/editProject/{id}", method = RequestMethod.POST)
    public ModelAndView saveEditedProject(@ModelAttribute Project project, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return new ModelAndView("error");
        }
        boolean isSaved = projectService.addProject(project);
        if (!isSaved) {
            return new ModelAndView("error");
        }
        return mv;
    }


    @RequestMapping(value = "/deleteProject/{id}", method = RequestMethod.GET)
    public ModelAndView deleteProjectById(@PathVariable Integer id) {
        projectService.delete(id);
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");
        return mv;
    }
}
