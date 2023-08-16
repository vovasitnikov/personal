package ru.sitnikov.personal.personal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.sitnikov.personal.personal.model.UserModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void getUserById() {
        Optional<UserModel> userFromDB = userRepository.findById(1);
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void deleteUser() {
    }
}