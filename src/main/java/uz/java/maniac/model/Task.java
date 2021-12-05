package uz.java.maniac.model;

import lombok.*;
import uz.java.maniac.model.dto.TaskDto;
import uz.java.maniac.model.template.AbsEntityInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task extends AbsEntityInteger implements EntityInterface<Task,TaskDto> {

    @Builder
    public Task(Integer id, Timestamp createdAt, boolean deleted, String name, String description) {
        super(id, createdAt, deleted);
        this.name = name;
        this.description = description;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    @Column(columnDefinition = "text")
    private String description;


    @Override
    public TaskDto toDto(){
        return TaskDto
                .builder()
                .id(getId())
                .name(name)
                .description(description)
                .build();
    }
}
