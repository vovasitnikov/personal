package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sitnikov.personal.personal.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
