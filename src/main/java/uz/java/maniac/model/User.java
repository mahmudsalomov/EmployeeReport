package uz.java.maniac.model;

import lombok.*;
import uz.java.maniac.model.dto.UserDto;
import uz.java.maniac.model.template.AbsEntityInteger;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "mob_users")
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"PHONE", "PASS"})})
public class User implements EntityInterface<User,UserDto>{
    @Id
    @Column(name = "idn")
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "PHONE")
    private String name;
    @Column(name = "PASS")
    private String pass;


    @Override
    public UserDto toDto(){
        return UserDto.builder()
                .name(name)
                .id(id)
                .build();
    }
}
