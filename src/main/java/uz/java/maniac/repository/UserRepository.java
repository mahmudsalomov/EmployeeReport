package uz.java.maniac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.java.maniac.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByName(String username);
    boolean existsByName(String username);
    Optional<User> findByNameAndPass(String name,String pass);
}
