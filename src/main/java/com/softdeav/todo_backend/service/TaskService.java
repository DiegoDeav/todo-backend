package com.softdeav.todo_backend.service;

import com.softdeav.todo_backend.entity.TaskEntity;
import com.softdeav.todo_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE
    public TaskEntity createTask(TaskEntity taskEntity) {
        Date now = new Date();
        taskEntity.setCreated_at(now);
        taskEntity.setUpdated_at(now);
        System.out.println(taskEntity);
        return taskRepository.save(taskEntity);
    }

    // READ (all)
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    // READ (by id)
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);  // Cambiado de findAllById a findById
    }

    // UPDATE
//    public TaskEntity updateTask(Long id, TaskEntity taskEntityDetails) {
//        TaskEntity taskEntity = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("TaskEntity not found"));
//
//        taskEntity.setTitle(taskEntityDetails.getTitle());
//        taskEntity.setDescription(taskEntityDetails.getDescription());
//        taskEntity.setCompleted(taskEntityDetails.isCompleted());
//        taskEntity.setDateInitial(taskEntityDetails.getDateInitial());
//        taskEntity.setDateFinished(taskEntityDetails.getDateFinished());
//
//        return taskRepository.save(taskEntity);
//    }

    // DELETE
    public void deleteTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskEntity not found"));
        taskRepository.delete(taskEntity);
    }
}
