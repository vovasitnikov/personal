package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sitnikov.personal.personal.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    //@Query("SELECT c FROM UserModel c where (c.lastName like concat('%', :lastName, '%' )";


}
