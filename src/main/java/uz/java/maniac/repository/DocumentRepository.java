package uz.java.maniac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.maniac.model.Document;
import uz.java.maniac.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    List<Document> findAllByUser(User user);
    List<Document> findAllByUserAndDeletedFalse(User user);
    Optional<Document> findByIdAndDeletedFalse(Integer id);
    Optional<Document> findByUserIdAndReportDate(Integer userId, Date reportDate);
    Optional<Document> findByUserAndReportDate(User user, Date reportDate);
    boolean existsByUserIdAndReportDate(Integer user_id,Date report_date);
}
