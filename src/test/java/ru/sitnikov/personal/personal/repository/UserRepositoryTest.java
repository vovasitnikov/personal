package ru.sitnikov.personal.personal.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.sitnikov.personal.personal.model.UserModel;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Sql("/data.sql")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void createUser() {
        UserModel userModel = new UserModel();
        userModel.setName("Bob");
        userModel.setLastName("Jones");
        UserModel saved  = userRepository.save(userModel);
        assertNotNull(saved);
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