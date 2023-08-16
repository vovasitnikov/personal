package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sitnikov.personal.personal.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
