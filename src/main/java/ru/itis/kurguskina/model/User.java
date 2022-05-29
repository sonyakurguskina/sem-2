package ru.itis.kurguskina.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, length = 64)
    private String password;

    public <T> User(String name, String email, String encode, List<T> emptyList, String code) {

    }

    public void setVerificationCode(String s) {
    }

    public enum State {
        NOT_CONFIRMED, CONFIRMED
    };

    @Column(length = 64)
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Appeal> appeals;

    private boolean enabled;
}