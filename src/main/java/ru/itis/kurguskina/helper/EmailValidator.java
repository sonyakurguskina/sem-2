package ru.itis.kurguskina.helper;

import lombok.RequiredArgsConstructor;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private final UserRepository userRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<User> account = Optional.ofNullable(userRepository.getUserByEmail(value));
        if (account.isPresent()) {
            return false;
        }
        return true;
    }
}
