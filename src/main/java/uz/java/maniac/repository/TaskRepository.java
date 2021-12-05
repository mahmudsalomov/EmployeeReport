package uz.java.maniac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.maniac.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findAllByDeletedFalse();
    List<Task> findAllByDeletedFalseOrderByCreatedAtDesc();

    Optional<Task> findByIdAndDeletedFalse(Integer id);
}
