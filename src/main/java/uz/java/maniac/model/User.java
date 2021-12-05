package uz.java.maniac.model;

import lombok.*;
import uz.java.maniac.model.dto.UserDto;
import uz.java.maniac.model.template.AbsEntityInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "my_user")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"name", "pass"})})
public class User implements EntityInterface<User,UserDto>{
    @Id
    private Integer id;
    private String name;
    private String pass;


    @Override
    public UserDto toDto(){
        return UserDto.builder()
                .name(name)
                .id(id)
                .build();
    }
}
