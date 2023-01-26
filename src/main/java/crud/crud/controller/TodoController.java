package crud.crud.controller;

import crud.crud.entity.Todos;
import crud.crud.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import crud.crud.dto.TaskDTO;

import java.util.List;

@Controller
@RequestMapping("/todo/")
public class TodoController {

    @Autowired
    private TodoService taskService;

    @GetMapping(path = "tasks")
    public ResponseEntity<?> getTasks() {
        List<Todos> todoList = taskService.getTasks();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping(path = "tasks/{id}")
    public ResponseEntity<?> getTask(@PathVariable("id") String taskId) {
        try {
            Todos task = taskService.getTask(taskId);

            return ResponseEntity.ok(task);
        }catch (RuntimeException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Resource Not Found", exc);
        }
    }

    @PostMapping(path = "tasks")
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO) {
        System.out.println(taskDTO.toString());
        Todos task = taskService.saveTask(taskDTO);
        return ResponseEntity.ok(task);
    }

    @PutMapping(path = "tasks/{id}")
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO) {
        Todos task = taskService.updateTask(taskDTO);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping(path = "tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String taskId) {
        String result = taskService.deleteTask(taskId);

        return ResponseEntity.ok(result);
    }
}
