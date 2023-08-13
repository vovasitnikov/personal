package ru.sitnikov.personal.personal.service;

import ru.sitnikov.personal.personal.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDto);

    UserDto getById(int id);

    List<UserDto> getAll();
}
