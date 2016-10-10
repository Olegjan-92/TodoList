package ru.javastudy.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Person;
import ru.javastudy.springMVC.service.UserActionService;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserActionService userService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getPerson() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new Person());
        modelAndView.setViewName("index");
        List<Person> persons = userService.getPersons();
        modelAndView.addObject("users", persons);
        return modelAndView;
    }

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/addtask", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("personAttribute") Person person) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new Person());
        modelAndView.setViewName("addTask");
        userService.saveUser(person);
        return modelAndView;
    }

    @RequestMapping(value = "/deletetask", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(value = "id", required = true) Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteTask");
        userService.delete(id);
        model.addAttribute("id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/edittask", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value="id", required = true) Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTask");
        model.addAttribute("personAttribute", userService.getPerson(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edittask", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person, @RequestParam(value="id", required=true) Integer id, Model model) {
        userService.saveUser(person);
        return "redirect:/";
     }

    @RequestMapping(value = "/addedTask", method = RequestMethod.POST)
    public ModelAndView checkUser(@RequestParam("task") String task, @RequestParam("status") String status) {
        ModelAndView modelAndView = new ModelAndView();
        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("addedTask");
        Person person = new Person();
        person.setTask(task);
        person.setStatus(status);
        userService.saveUser(person);
        modelAndView.addObject("userJSP", person);
        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }
}
