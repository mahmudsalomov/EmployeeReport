package uz.java.maniac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import uz.java.maniac.model.Field;
import uz.java.maniac.model.template.InputType;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FieldDto implements DtoInterface<Field,FieldDto>{
    public Integer id;
    public InputType type;
    public String name;
    public String placeholder;
    public TaskDto task;
    public Integer taskId;


    @Override
    public Field toEntity() {
        return Field
                .builder()
                .id(id)
                .type(type)
                .name(name)
                .placeholder(placeholder)
                .task(task.toEntity())
                .taskId(taskId)
                .build();
    }
}
