package dev.yuri.dio.spring.security.jwt.respository;

import dev.yuri.dio.spring.security.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = (:username)")
    User findByUsername(@Param("username") String username);
}
