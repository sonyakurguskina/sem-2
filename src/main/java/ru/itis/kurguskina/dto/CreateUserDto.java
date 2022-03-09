package ru.itis.kurguskina.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateUserDto {
    @NotBlank(message = "Name shouldn't be blank!")
    private String name;

    @NotBlank(message = "Email shouldn't be blank!")
    private String email;

    @NotBlank(message = "Email shouldn't be blank!")
    @Size(min=6, max=20)
    private String password;

    public CreateUserDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
