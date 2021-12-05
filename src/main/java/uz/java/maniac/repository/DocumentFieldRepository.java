package uz.java.maniac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.maniac.model.Document;
import uz.java.maniac.model.DocumentField;

import java.time.Month;
import java.util.List;
import java.util.Optional;

public interface DocumentFieldRepository extends JpaRepository<DocumentField,Integer> {
    List<DocumentField> findAllByTaskNumber(Integer taskNumber);
    List<DocumentField> findAllByTaskNumberAndDocument(Integer taskNumber,Document document);

    List<DocumentField> findAllByDocument(Document document);
    List<DocumentField> findAllByDocumentId(Integer id);
    List<DocumentField> findAllByDocumentIdOrderByCreatedAtAsc(Integer id);
    List<DocumentField> findAllByDocumentAndDeletedFalse(Document document);
    Optional<DocumentField> findFirstByDocumentOrderByTaskNumberDesc(Document document);
    Optional<DocumentField> findFirstByOrderByTaskNumberDesc();

}
