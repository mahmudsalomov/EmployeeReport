package uz.java.maniac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import uz.java.maniac.model.DocumentField;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentFieldDto implements DtoInterface<DocumentField,DocumentFieldDto>{
    public Integer id;
    public String data;
    public DocumentDto document;
    public Integer documentId;
    public FieldDto field;
    public Integer fieldId;
    public Integer taskNumber;
    public TaskDto taskDto;
    public Integer taskId;

    @Override
    public DocumentField toEntity() {
        return DocumentField
                .builder()
                .id(id)
                .document(document.toEntity())
                .documentId(documentId)
                .data(data)
                .taskNumber(taskNumber)
                .field(field.toEntity())
                .fieldId(fieldId)
                .taskId(taskId)
                .task(field.task.toEntity())
                .build();
    }
}
