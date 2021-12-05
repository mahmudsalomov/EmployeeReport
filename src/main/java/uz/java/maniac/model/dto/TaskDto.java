package uz.java.maniac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import uz.java.maniac.model.Task;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto implements DtoInterface<Task,TaskDto>{
    public Integer id;
    public String name;
    public String description;

    @Override
    public Task toEntity() {
        return Task
                .builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }
}
