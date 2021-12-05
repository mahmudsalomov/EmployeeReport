package uz.java.maniac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.maniac.model.Field;
import uz.java.maniac.model.Task;

import java.util.List;
import java.util.Optional;

public interface FieldRepository extends JpaRepository<Field,Integer> {
    List<Field> findAllByTask(Task task);
    List<Field> findAllByTaskAndDeletedFalse(Task task);
    List<Field> findAllByTaskIdAndDeletedFalse(Integer task_id);

//    Optional<Field>
}
