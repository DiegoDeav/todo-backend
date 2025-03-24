package com.softdeav.todo_backend.controller;

import com.softdeav.todo_backend.entity.Task;
import com.softdeav.todo_backend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // Indica que es un controlador REST
@RequestMapping("/api/tasks") // Ruta base para los endpoints
public class TaskController {
    private final TaskService taskService;

    // Inyección de dependencias por constructor
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // GET /api/tasks
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}") // GET /api/tasks/{id}
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // POST /api/tasks
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}") // PUT /api/tasks/{id}
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}") // DELETE /api/tasks/{id}
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
