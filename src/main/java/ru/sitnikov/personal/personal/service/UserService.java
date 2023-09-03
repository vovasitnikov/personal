package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

     void update(UserDto userDto);

     void delete(Long id);

    UserDto getById(Long id);

    List<UserDto> getAll();


}
