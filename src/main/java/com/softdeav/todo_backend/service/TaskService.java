package com.softdeav.todo_backend.service;

import com.softdeav.todo_backend.entity.Task;
import com.softdeav.todo_backend.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //Indica que es un componente de servicio

public class TaskService {
    private final TaskRepository taskRepository;

    // inyeccion de dependencias por constructor
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.findAllById(id);
    }

    public Task updateTask(Long id, Task taskDetails) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }
        return null; // Podrías lanzar una excepción aquí en un caso real
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
