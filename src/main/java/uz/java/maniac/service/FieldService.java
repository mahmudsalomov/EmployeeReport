package uz.java.maniac.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.java.maniac.model.Field;
import uz.java.maniac.model.Task;
import uz.java.maniac.model.dto.FieldDto;
import uz.java.maniac.repository.FieldRepository;
import uz.java.maniac.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FieldService implements ServiceInterface<Field, FieldDto> {
    private final FieldRepository fieldRepository;
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public FieldService(FieldRepository fieldRepository, TaskRepository taskRepository, TaskService taskService) {
        this.fieldRepository = fieldRepository;
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    @Override
    public Field add(FieldDto fieldDto, UserDetails user) {
        try {
            Optional<Task> task = taskRepository.findByIdAndDeletedFalse(fieldDto.taskId);
            if (task.isPresent()){
                fieldDto.task=task.get().toDto();
                return fieldRepository.save(fieldDto.toEntity());
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Field edit(FieldDto fieldDto, UserDetails user) {
        return null;
    }

    @Override
    public List<Field> all() {
        try {
            return fieldRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Field one(Integer id) {
        try {
            Optional<Field> field = fieldRepository.findById(id);
            return field.orElse(null);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean delete(Integer id, UserDetails user) {
        Optional<Field> field = fieldRepository.findById(id);
        field.ifPresent(f->{
            f.setDeleted(true);
            fieldRepository.save(f);
        });
        return true;
    }


    public List<Field> allByTask(Task task){
        try {
            return fieldRepository.findAllByTaskAndDeletedFalse(task);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<FieldDto> allByTaskId(Integer id){
        try {
            List<Field> all = fieldRepository.findAllByTaskIdAndDeletedFalse(id);
            List<FieldDto> dtoList=new ArrayList<>();
            all.forEach(f->{
                dtoList.add(f.toDto());
            });
            return dtoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
