package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.model.User;
import ru.sitnikov.personal.personal.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        User user = userRepository.save(toUser(userDto));
        return toUserDto(user);
    }

    @Override
    public UserDto getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("User with id " + id + " not found")));
        return toUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(this::toUserDto).collect(Collectors.toList());
    }

    private User toUser(UserDto dto) {
        return new User(dto.getId(), dto.getName());
    }

    private UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
