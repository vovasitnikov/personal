package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sitnikov.personal.personal.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
