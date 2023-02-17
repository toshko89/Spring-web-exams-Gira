package com.example.gira.web;

import com.example.gira.model.dto.TaskDTO;
import com.example.gira.service.TaskService;
import com.example.gira.session.LoggedUserSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final LoggedUserSession loggedUserSession;

    public TaskController(TaskService taskService, LoggedUserSession loggedUserSession) {
        this.taskService = taskService;
        this.loggedUserSession = loggedUserSession;
    }

    @ModelAttribute
    public TaskDTO initTaskDTO() {
        return new TaskDTO();
    }

    @GetMapping("/add-task")
    public String addTask(){
//        if(!loggedUserSession.isLoggeinIn()){
//            return "redirect:/login";
//        }

        return "add-task";
    }

    @PostMapping("/add-task")
    public String addPost(@Valid TaskDTO taskDTO, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (!loggedUserSession.isLoggeinIn()) {
            return "redirect:/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("taskDTO", taskDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskDTO", bindingResult);

            return "redirect:/add-task";
        }

        this.taskService.addTask(taskDTO);

        return "redirect:/home";
    }
}
