package com.example.gira.service;

import com.example.gira.model.Task;
import com.example.gira.model.dto.TaskDTO;
import com.example.gira.model.enums.ClassificaionName;
import com.example.gira.model.enums.Progress;
import com.example.gira.repository.TaskRepo;
import com.example.gira.session.LoggedUserSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final LoggedUserSession loggedUserSession;

    public TaskService(TaskRepo taskRepo, ClassificationService classificationService,
                       UserService userService, LoggedUserSession loggedUserSession) {
        this.taskRepo = taskRepo;
        this.classificationService = classificationService;
        this.userService = userService;
        this.loggedUserSession = loggedUserSession;
    }

    public void initTasksDB() {
        if (this.taskRepo.count() == 0) {

            Task task = new Task()
                    .setName("Dark Mode")
                    .setDescription("Make the app dark mode compatible")
                    .setDueDate(LocalDate.now())
                    .setClassification(classificationService.findByName(ClassificaionName.FEATURE))
                    .setProgress(Progress.IN_PROGRESS)
                    .setUser(userService.getUserById(1L));

            this.taskRepo.save(task);

            Task task2 = new Task()
                    .setName("New Task")
                    .setDescription("Make new task")
                    .setDueDate(LocalDate.now())
                    .setClassification(classificationService.findByName(ClassificaionName.SUPPORT))
                    .setProgress(Progress.OPEN)
                    .setUser(userService.getUserById(2L));

            this.taskRepo.save(task2);

            Task task3 = new Task()
                    .setName("Bug")
                    .setDescription("Fix bug")
                    .setDueDate(LocalDate.now())
                    .setClassification(classificationService.findByName(ClassificaionName.BUG))
                    .setProgress(Progress.COMPLETED)
                    .setUser(userService.getUserById(3L));

            this.taskRepo.save(task3);

        }
    }

    public void addTask(TaskDTO taskDTO) {
        Task task = new Task()
                .setUser(userService.getUserById(loggedUserSession.getId()))
                .setClassification(classificationService.findByName(ClassificaionName.valueOf(taskDTO.getClassification())))
                .setDescription(taskDTO.getDescription())
                .setDueDate(taskDTO.getDueDate())
                .setName(taskDTO.getName())
                .setProgress(Progress.OPEN);

        this.taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return this.taskRepo.findAll();
    }

    public void progressTask(Long id) {
        Task task = this.taskRepo.findById(id).orElse(null);
        if (task != null) {
            Progress progress = task.getProgress();
            switch (progress) {
                case OTHER -> this.taskRepo.save(task.setProgress(Progress.OPEN));
                case OPEN -> this.taskRepo.save(task.setProgress(Progress.IN_PROGRESS));
                case IN_PROGRESS -> this.taskRepo.save(task.setProgress(Progress.COMPLETED));
                case COMPLETED -> this.taskRepo.delete(task);
            }
        }
    }
}
