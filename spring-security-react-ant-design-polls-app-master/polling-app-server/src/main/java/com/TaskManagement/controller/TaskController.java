package com.TaskManagement.controller;

import com.TaskManagement.model.TasksEntity;
import com.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(value = "*")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/get/{taskId}")
    public Optional<TasksEntity> getAllTasks(@RequestHeader String authToken, @PathVariable Long taskId){
        return taskService.getAllTasks(taskId);
    }

    @GetMapping("/findbypending")
    public List<TasksEntity> getByPending(@RequestHeader String authToken){
        return taskService.getByStatus("pending");
    }

    @GetMapping("/findbycompleted")
    public List<TasksEntity> getByCompleted(@RequestHeader String authToken){
        return taskService.getByStatus("completed");
    }

    @PostMapping("/add")
    public void addTask(@RequestHeader String authToken,@RequestBody TasksEntity tasks){
        taskService.addTasks(tasks);
    }

    @PutMapping("/update/{taskId}")
    public void updateTask(@RequestHeader String authToken,@PathVariable Long taskId, @RequestBody TasksEntity tasks){
        taskService.updateTasks(taskId,tasks);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteTask(@RequestHeader String authToken,@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping("/statusupdate/{taskId}")
    public void changeStatus(@PathVariable Long taskId) {
        taskService.updateStatus(taskId,"Completed");

    }
}
