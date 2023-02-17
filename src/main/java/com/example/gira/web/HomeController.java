package com.example.gira.web;

import com.example.gira.model.Task;
import com.example.gira.service.TaskService;
import com.example.gira.session.LoggedUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final LoggedUserSession loggedUserSession;
    private final TaskService taskService;

    public HomeController(LoggedUserSession loggedUserSession, TaskService taskService) {
        this.loggedUserSession = loggedUserSession;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        List<Task> allTasks = this.taskService.getAllTasks();
        model.addAttribute("allTasks", allTasks);

        return "home";
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable Long id) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }
        System.out.println(id);
        this.taskService.progressTask(id);

        return "redirect:/home";
    }
}
