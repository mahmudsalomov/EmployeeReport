package uz.java.maniac.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.java.maniac.model.User;
import uz.java.maniac.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User findForSecurityByUsername(String username){
//        User user = userRepository.findByName(username);
//        if (user!=null) user.setPass(passwordEncoder.encode(user.getPass()));
//        return user;
//    }


}
