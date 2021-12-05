package uz.java.maniac.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import uz.java.maniac.model.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDto implements DtoInterface<Document,DocumentDto>{
    public Integer id;
    public Date reportDate;
    public UserDto user;
    public Integer userId;
    public boolean editPermission;

    @Override
    public Document toEntity() {
        return Document
                .builder()
                .id(id)
                .reportDate(reportDate)
                .user(user.toEntity())
                .userId(userId)
                .editPermission(editPermission)
                .build();
    }
}
