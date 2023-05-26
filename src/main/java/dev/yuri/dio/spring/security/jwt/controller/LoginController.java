package dev.yuri.dio.spring.security.jwt.controller;

import dev.yuri.dio.spring.security.jwt.dto.Login;
import dev.yuri.dio.spring.security.jwt.dto.Sessao;
import dev.yuri.dio.spring.security.jwt.model.User;
import dev.yuri.dio.spring.security.jwt.respository.UserRepository;
import dev.yuri.dio.spring.security.jwt.security.JWTCreator;
import dev.yuri.dio.spring.security.jwt.security.JWTObject;
import dev.yuri.dio.spring.security.jwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class LoginController {
    private final PasswordEncoder encoder;
    private final SecurityConfig securityConfig;
    private final UserRepository userRepository;

    public LoginController(PasswordEncoder encoder, SecurityConfig securityConfig, UserRepository userRepository) {
        this.encoder = encoder;
        this.securityConfig = securityConfig;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
        User user = userRepository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
