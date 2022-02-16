package ru.itis.kurguskina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    UserDto findByEmail(String email);
}
