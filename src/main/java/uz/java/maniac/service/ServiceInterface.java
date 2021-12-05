package uz.java.maniac.service;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@NoRepositoryBean
public interface ServiceInterface<T,K> extends Serializable {
    T add(K k, UserDetails user);
    T edit(K k, UserDetails user);
    List<T> all();
    T one(Integer id);
    boolean delete(Integer id, UserDetails user);
}
