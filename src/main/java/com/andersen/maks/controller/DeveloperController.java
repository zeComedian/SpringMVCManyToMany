package com.andersen.maks.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import com.andersen.maks.entities.Developer;
import com.andersen.maks.service.DeveloperService;
import com.andersen.maks.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class DeveloperController {

    private DeveloperService developerService;
    private ProjectService projectService;


    public DeveloperController(){

    }

    @Autowired
    public DeveloperController(DeveloperService developerService, ProjectService projectService){
        this.developerService = developerService;
        this.projectService = projectService;
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView hello(HttpServletResponse response) throws IOException{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }


    //Get all developers
    @RequestMapping(value = "/allDevelopers", method = RequestMethod.POST)
    public ModelAndView displayAllDevelopers(){
        ModelAndView mv = new ModelAndView();
        List developersList = developerService.getAll();
        List projectsList = projectService.getAll();
        mv.addObject("developersList", developersList);
        mv.addObject("projectsList", projectsList);
        return mv;
    }


    @RequestMapping(value = "/allDevelopers", method = RequestMethod.GET)
    public ModelAndView getAllDevelopersToView(){
        System.out.println("All Developers");
        ModelAndView mv = new ModelAndView();
        List developersList = developerService.getAll();
        List projectsList = projectService.getAll();
        mv.addObject("developersList", developersList);
        mv.addObject("projectsList", projectsList);
        return mv;
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.GET)
    public ModelAndView displayNewDeveloperForm(){
        ModelAndView mv = new ModelAndView("addDeveloper");
        mv.addObject("headerMessage", "Add Developer Details");
        mv.addObject("developer", new Developer());
        return mv;
    }

    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public ModelAndView saveNewDeveloper(@ModelAttribute Developer developer, BindingResult result){
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");

        if (result.hasErrors()){
            return new ModelAndView("error");
        }
        boolean isAdded = developerService.addDeveloper(developer);
        if (isAdded){
            mv.addObject("message", "New Developer added");
        }else {
            return new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping(value = "/editDeveloper/{id}", method = RequestMethod.GET)
    public ModelAndView displayEditDeveloperForm(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("/editDeveloper");
        Developer developer = developerService.getDeveloperById(id);
        mv.addObject("headerMessage", "Edit Developer Details");
        mv.addObject("developer", developer);
        return mv;
    }

    @RequestMapping(value = "/editDeveloper/{id}", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@ModelAttribute Developer developer, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return new ModelAndView("error");
        }
        boolean isSaved = developerService.addDeveloper(developer);
        if (!isSaved) {
            return new ModelAndView("error");
        }
        return mv;
    }

    @RequestMapping(value = "/deleteDeveloper/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Integer id) {
        boolean isDeleted = developerService.delete(id);
        System.out.println("Developer deletion respone: " + isDeleted);
        ModelAndView mv = new ModelAndView("redirect:/allDevelopers");
        return mv;
    }
}
