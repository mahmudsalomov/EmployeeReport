package uz.java.maniac.controller.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.model.dto.TaskDto;
import uz.java.maniac.service.ServiceInterface;
import uz.java.maniac.service.TaskService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/task")
public class TaskController implements ControllerInterface<HttpEntity<?>, TaskDto> {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public HttpEntity<?> add(TaskDto dto, UserDetails user) {
        return ResponseEntity.ok("");
    }

    @Override
    public HttpEntity<?> edit(TaskDto dto, UserDetails user) {

        return ResponseEntity.ok("");
    }

    @Override
    public HttpEntity<?> all() {
        return ResponseEntity.ok(taskService.all());
    }

    @Override
    public HttpEntity<?> one(Integer id, UserDetails user) {
        return ResponseEntity.ok(taskService.one(id));
    }

    @Override
    public HttpEntity<?> delete(Integer id, UserDetails user) {
        return null;
    }
}
