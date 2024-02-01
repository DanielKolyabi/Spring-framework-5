package com.example.todolist.controllers;

import com.example.todolist.model.Task;
import com.example.todolist.model.TaskStatus;
import com.example.todolist.service.TaskService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks") //http://localhost:8080/api/tasks
@Slf4j
@AllArgsConstructor
public class TaskRestController {

  private final TaskService taskService;


  @PostMapping
  public Task addTask(@RequestBody Task task) {
    log.info("Received add task request: {}", task.getDescription());
    return taskService.addTask(task);
  }


  @GetMapping
  public List<Task> getAllTasks() {
    log.info("Received get all tasks request");
    return taskService.getAllTasks();
  }


  @GetMapping("/status/{status}")
  public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
    log.info("Received get tasks by status request: ", status);
    return taskService.getTasksByStatus(status);
  }


  @PutMapping("/{id}/status/{status}")
  public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
    log.info("Received update task status request: id = {}, status = {}", id, status);
    return taskService.updateTaskStatus(id, status);
  }


  @PutMapping("/{id}")
  public Task updateTask(@PathVariable Long id, @RequestBody Task updateTask) {
    log.info("Received update task request: id = {}, task = {}", id, updateTask);
    return taskService.updateTask(id, updateTask);
  }


  @DeleteMapping("/{id}")
  public void deleteTask(@PathVariable Long id) {
    log.info("Received delete task request: id = {}", id);
    taskService.deleteTask(id);
  }


  @GetMapping("/{id}")
  public Task getTasksById(@PathVariable Long id) {
    log.info("Received get task request: id = {}", id);
    return taskService.getTaskById(id);
  }
}
