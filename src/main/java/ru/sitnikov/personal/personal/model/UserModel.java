package ru.sitnikov.personal.personal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
/*@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uniqEmail", columnNames = "email"),
                @UniqueConstraint(name = "uniqLogin", columnNames = "login"),
        })*/
public class UserModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator", sequenceName = "user_seq", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "position")
    private String position; //должность сотрудника

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    public UserModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
