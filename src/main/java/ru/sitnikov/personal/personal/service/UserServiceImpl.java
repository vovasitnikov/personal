package ru.sitnikov.personal.personal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.model.UserModel;
import ru.sitnikov.personal.personal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

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
    public UserDto getById(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("User with id " + id + " not found")));
        return toUserDto(user);
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.save(toUser(userDto));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserModel> all = userRepository.findAll();
        List<UserDto> allUserDto = new ArrayList<>();
        for (UserModel userModel : all) {
            UserDto userDto = toUserDto(userModel);
            allUserDto.add(userDto);
        }
        return allUserDto;
    }

    @Override
    public List<UserModel> selectUsersByLastname(String lastname) {
        return userRepository.selectUsersByLastname(lastname);
    }

    @Override
    public List<UserModel> selectUsersByNameAndLastname(String name, String lastname) {
        return userRepository.selectUsersByNameAndLastname(name, lastname);
    }

    private UserModel toUser(UserDto dto) {
        return new UserModel(dto.getId(), dto.getName(), dto.getLastName());
    }

    private UserDto toUserDto(UserModel user) {
        return new UserDto(user.getId(), user.getName(), user.getLastName());
    }
}
