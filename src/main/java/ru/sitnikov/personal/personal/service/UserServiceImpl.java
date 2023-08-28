package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.model.UserModel;
import ru.sitnikov.personal.personal.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        UserModel user = userRepository.save(toUser(userDto));
        return toUserDto(user);
    }

    @Override
    public UserDto getById(int id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("User with id " + id + " not found")));
        return toUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this::toUserDto).collect(Collectors.toList());
    }

    private UserModel toUser(UserDto dto) {
        return new UserModel(dto.getId(), dto.getName());
    }

    private UserDto toUserDto(UserModel user) {
        return new UserDto(user.getId(), user.getName(), user.getLastName());
    }
}
