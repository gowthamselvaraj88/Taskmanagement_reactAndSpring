package com.TaskManagement.service;

import com.TaskManagement.model.TasksEntity;
import com.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    public TaskRepository taskRepository;

    public Optional<TasksEntity> getAllTasks(Long taskId){
        Optional<TasksEntity> taskUpdate = taskRepository.findById(taskId);

        return taskUpdate;
    }

    public  List<TasksEntity> getByStatus(String status){
        List<TasksEntity> tasksEntity = taskRepository.findByStatus(status);
        return tasksEntity;
    }
    public void  addTasks(TasksEntity tasks){
        taskRepository.save(tasks);
    }
    public void  updateTasks(Long taskId, TasksEntity tasks){
        Optional<TasksEntity> taskUpdate = taskRepository.findById(taskId);

        if (taskUpdate.isPresent()) {
            TasksEntity  tasksEntity = taskUpdate.get();

            tasksEntity.setTitle(tasks.getTitle());
            tasksEntity.setDescription(tasks.getDescription());
            tasksEntity.setStartDate(tasks.getStartDate());
            tasksEntity.setEndDate(tasks.getEndDate());

            taskRepository.save(tasksEntity);
        }else {
            System.out.println("Not Found!");
        }
    }
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

    public void updateStatus(Long taskId, String status){
        Optional<TasksEntity> taskStatus = taskRepository.findById(taskId);

        if (taskStatus.isPresent()) {
            TasksEntity  tasksEntity = taskStatus.get();

            tasksEntity.setStatus(status);

            taskRepository.save(tasksEntity);
        }else{
            System.out.println("Not Found!");
        }
    }

}
