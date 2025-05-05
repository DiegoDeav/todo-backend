package com.softdeav.todo_backend.repository;
import com.softdeav.todo_backend.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    // JpaRepository ya provee métodos como save(), findAll(), findById(), delete()
    // Puedes agregar métodos personalizados si necesitas, por ejemplo:
    // List<TaskEntity> findByCompleted(boolean completed);
}
