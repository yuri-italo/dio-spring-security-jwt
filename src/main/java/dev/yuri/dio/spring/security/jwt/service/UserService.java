package dev.yuri.dio.spring.security.jwt.service;

import dev.yuri.dio.spring.security.jwt.model.User;
import dev.yuri.dio.spring.security.jwt.respository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(User user) {
        String password = user.getPassword();
        // criptografando antes de salvar no banco
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }


}
