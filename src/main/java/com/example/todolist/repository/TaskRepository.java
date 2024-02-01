package com.example.todolist.repository;

import com.example.todolist.model.Task;
import com.example.todolist.model.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

  List<Task> findAllByStatus(TaskStatus status);
}
