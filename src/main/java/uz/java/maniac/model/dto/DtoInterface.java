package uz.java.maniac.model.dto;

import java.io.Serializable;

public interface DtoInterface<T,U>  extends Serializable{
    T toEntity();
}
