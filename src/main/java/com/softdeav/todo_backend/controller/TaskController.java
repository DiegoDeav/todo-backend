package com.softdeav.todo_backend.controller;

import com.softdeav.todo_backend.entity.TaskEntity;
import com.softdeav.todo_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // CREATE
        @PostMapping("/create")
    public ResponseEntity<TaskEntity> createTask(@RequestBody TaskEntity taskEntity) {
        TaskEntity createdTaskEntity = taskService.createTask(taskEntity);
        return ResponseEntity.ok(createdTaskEntity);
    }

    // READ (all)
    @GetMapping("/getAll")
    public ResponseEntity<List<TaskEntity>> getAllTasks() {
        List<TaskEntity> taskEntities = taskService.getAllTasks();
        return ResponseEntity.ok(taskEntities);
    }

    // READ (by id)
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
//    @PutMapping("/update/{id}")
//    public ResponseEntity<TaskEntity> updateTask(@PathVariable Long id, @RequestBody TaskEntity taskEntityDetails) {
//        TaskEntity updatedTaskEntity = taskService.updateTask(id, taskEntityDetails);
//        return ResponseEntity.ok(updatedTaskEntity);
//    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
