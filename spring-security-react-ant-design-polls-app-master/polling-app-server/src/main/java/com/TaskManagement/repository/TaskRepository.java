package com.TaskManagement.repository;

import com.TaskManagement.model.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
    List<TasksEntity> findByStatus(String status);

    Optional<TasksEntity> findById(Long taskId);
}