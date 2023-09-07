package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto save(UserDto userDto);

     void update(UserDto userDto);

     void delete(Long id);

    UserDto getById(Long id);

    List<UserDto> getAll();

    List<UserModel> selectUsersByLastname(String lastname);

    List<UserModel> selectUsersByNameAndLastname(String name, String lastname);

}
