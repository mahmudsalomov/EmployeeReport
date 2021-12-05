package uz.java.maniac.model;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityInterface<T,U> {

    U toDto();

}
