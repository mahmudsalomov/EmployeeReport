package uz.java.maniac.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.java.maniac.model.Task;
import uz.java.maniac.model.dto.TaskDto;
import uz.java.maniac.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ServiceInterface<Task, TaskDto>{
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(TaskDto taskDto, UserDetails user) {
        return null;
    }

    @Override
    public Task edit(TaskDto taskDto, UserDetails user) {
        return null;
    }

    @Override
    public List<Task> all(){
        return taskRepository.findAllByDeletedFalseOrderByCreatedAtDesc();
    }

    @Override
    public Task one(Integer id) {
        return taskRepository.findByIdAndDeletedFalse(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id, UserDetails user) {
        Optional<Task> task = taskRepository.findByIdAndDeletedFalse(id);
        task.ifPresent(t->{
            t.setDeleted(true);
            taskRepository.save(t);
        });
        return true;
    }


}
