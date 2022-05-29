package ru.itis.kurguskina.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.kurguskina.helper.ValidEmail;
import ru.itis.kurguskina.helper.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @NotBlank
    @Size(min = 2, max = 12)
    private String name;


    @Validator
    private String password;

    @Email
    @ValidEmail
    @NotBlank
    private String email;


}
