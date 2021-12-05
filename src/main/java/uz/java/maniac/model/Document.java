package uz.java.maniac.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import uz.java.maniac.model.dto.DocumentDto;
import uz.java.maniac.model.template.AbsEntityInteger;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"user_id", "report_date"})})
public class Document extends AbsEntityInteger implements EntityInterface<Document,DocumentDto>{

    @Builder
    public Document(Integer id, Timestamp createdAt, boolean deleted, Date reportDate, User user, Integer userId, boolean editPermission) {
        super(id, createdAt, deleted);
        this.reportDate = reportDate;
        this.user = user;
        this.userId = userId;
        this.editPermission=editPermission;
    }

    public Document(Date reportDate, User user, Integer userId,boolean editPermission) {
        this.reportDate = reportDate;
        this.user = user;
        this.userId = userId;
        this.editPermission=editPermission;
    }

    @Column(name = "report_date",columnDefinition = "date")
    @DateTimeFormat(pattern="dd.MM.yyyy")
    private Date reportDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    private User user;


    @Column(name = "user_id", nullable = false)
    private Integer userId;

    private boolean editPermission;

    @Override
    public DocumentDto toDto() {
        return DocumentDto
                .builder()
                .id(getId())
                .reportDate(reportDate)
                .user(user.toDto())
                .userId(userId)
                .editPermission(editPermission)
                .build();
    }
}
