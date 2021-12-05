package uz.java.maniac.model.template;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class FormData {
    public Integer name;
    public String value;
}
