package ru.sitnikov.personal.personal.repository;

import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import ru.sitnikov.personal.personal.model.UserModel;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    void createUser() {
        UserModel userModel = new UserModel();
        userModel.setName("Bob");
        userModel.setLastName("Jones");
        userModel.setEmail("ivanov@mail.ru");
        userModel.setLogin("petro");
        UserModel saved  = userRepository.save(userModel);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals("Bob", saved.getName());
        assertEquals("Jones", saved.getLastName());
    }

    @Test
    void updateUser() {
        Optional<UserModel> userToUpdate = userRepository.findById(1);
        assertNotNull(userToUpdate);
        UserModel userModelToUpdate = userToUpdate.get();
        userModelToUpdate.setName("new name");
        UserModel saved  = userRepository.save(userModelToUpdate);
        assertNotNull(saved);
        Optional<UserModel> userToUpdate2 = userRepository.findById(1);
        assertEquals("new name", userToUpdate2.get().getName());
    }

    @Test
    void getUserById() {
        Optional<UserModel> userFromDB = userRepository.findById(1);
        assertNotNull(userFromDB);
        assertEquals("Ivan", userFromDB.get().getName());
    }

    @Test
    void getAllUsers() {
        List<UserModel> modelList = userRepository.findAll();
        assertFalse(modelList.isEmpty());
    }

    @Test
    void deleteUser() {
        userRepository.deleteById(1);
        Optional<UserModel> userModel = userRepository.findById(1);
        assertTrue(userModel.isEmpty());
    }

}