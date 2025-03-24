package com.softdeav.todo_backend.repository;
import com.softdeav.todo_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // JpaRepository ya provee métodos como save(), findAll(), findById(), delete()
    // Puedes agregar métodos personalizados si necesitas, por ejemplo:
    // List<Task> findByCompleted(boolean completed);
}
