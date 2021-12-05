package uz.java.maniac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import uz.java.maniac.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements DtoInterface<User,UserDto>{
    public Integer id;
    public String name;
    public String pass;

    @Override
    public User toEntity() {
        return User
                .builder()
                .id(id)
                .pass(pass)
                .name(name)
                .build();
    }
}
