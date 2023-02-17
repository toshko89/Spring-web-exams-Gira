package com.example.gira.init;

import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DBInit implements CommandLineRunner {


    private final UserService userService;
    private final ClassificationService classificationService;
    private final TaskService taskService;

    public DBInit(UserService userService, ClassificationService classificationService, TaskService taskService) {
        this.userService = userService;
        this.classificationService = classificationService;
        this.taskService = taskService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.classificationService.initClassificationsDB();
        this.userService.initUsersDB();
        this.taskService.initTasksDB();

    }
}
