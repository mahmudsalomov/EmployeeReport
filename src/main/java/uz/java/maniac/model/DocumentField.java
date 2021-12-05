package uz.java.maniac.model;

import lombok.*;
import uz.java.maniac.model.dto.DocumentFieldDto;
import uz.java.maniac.model.template.AbsEntityInteger;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
//@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"document_id", "field_id"})})
public class DocumentField extends AbsEntityInteger implements EntityInterface<DocumentField, DocumentFieldDto> {

    @Builder
    public DocumentField(Integer id, Timestamp createdAt, boolean deleted, String data, Document document, Integer documentId, Field field, Integer fieldId, Integer taskNumber) {
        super(id, createdAt, deleted);
        this.data = data;
        this.document = document;
        this.documentId = documentId;
        this.field = field;
        this.fieldId = fieldId;
        this.taskNumber = taskNumber;
    }

    public DocumentField(String data, Document document, Integer documentId, Field field, Integer fieldId, Integer taskNumber) {
        this.data = data;
        this.document = document;
        this.documentId = documentId;
        this.field = field;
        this.fieldId = fieldId;
        this.taskNumber = taskNumber;
    }

    public DocumentField(String data, Document document, Integer documentId, Field field, Integer fieldId) {
        this.data = data;
        this.document = document;
        this.documentId = documentId;
        this.field = field;
        this.fieldId = fieldId;
    }

    @Column(columnDefinition = "text")
    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id",updatable = false,insertable = false)
    private Document document;

    @Column(name = "document_id", nullable = false)
    private Integer documentId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id",updatable = false,insertable = false)
    private Field field;


    @Column(name = "field_id", nullable = false)
    private Integer fieldId;

    @Column(name = "document_task_number", nullable = false)
    private Integer taskNumber;

    @Override
    public DocumentFieldDto toDto() {
        return DocumentFieldDto
                .builder()
                .id(getId())
                .document(document!=null?document.toDto():null)
                .data(data)
                .taskNumber(taskNumber)
                .documentId(documentId)
                .field(field.toDto())
                .fieldId(fieldId)
                .build();
    }
}
