package uz.java.maniac.model;

import lombok.*;
import uz.java.maniac.model.dto.FieldDto;
import uz.java.maniac.model.template.AbsEntityInteger;
import uz.java.maniac.model.template.InputType;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter

@NoArgsConstructor

@Entity
public class Field extends AbsEntityInteger implements EntityInterface<Field, FieldDto>{

    @Builder
    public Field(Integer id, Timestamp createdAt, boolean deleted, InputType type, String name, String placeholder, Task task, Integer taskId) {
        super(id, createdAt, deleted);
        this.type = type;
        this.name = name;
        this.placeholder = placeholder;
        this.task = task;
        this.taskId = taskId;
    }

    public Field(InputType type, String name, String placeholder, Task task, Integer taskId) {
        this.type = type;
        this.name = name;
        this.placeholder = placeholder;
        this.task = task;
        this.taskId = taskId;
    }

    private InputType type;
    private String name;
    private String placeholder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id",updatable = false,insertable = false)
    private Task task;


    @Column(name = "task_id", nullable = false)
    private Integer taskId;

    @Override
    public FieldDto toDto() {
        return FieldDto
                .builder()
                .id(getId())
                .name(name)
                .placeholder(placeholder)
                .type(type)
                .task(task.toDto())
                .taskId(taskId)
                .build();
    }
}
