package ru.sitnikov.personal.personal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sitnikov.personal.personal.model.UserModel;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT c FROM UserModel c where lower(c.lastName) like lower(concat('%', :lastName,'%'))")
    List<UserModel> selectUsersByLastname(@Param("lastName") String lastName);

    @Query("SELECT c FROM UserModel c where " +
            "lower(c.name) like lower(concat('%', :name,'%')) " +
            "and lower(c.lastName) like lower(concat('%', :lastName,'%'))")
    List<UserModel> selectUsersByNameAndLastname(@Param("name") String name, @Param("lastName") String lastName);

}
