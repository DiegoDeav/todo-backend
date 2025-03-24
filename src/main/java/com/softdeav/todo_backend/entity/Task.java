package com.softdeav.todo_backend.entity;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data // Lombok: genera getters, setters, toString, equals, hashCode
@Entity // Indica que es una entidad JPA

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincremental
    private Long id;
    private String title;
    private String description;
    private boolean completed = false;
    private Data dateinitial;
    private Data datefinished;
}
