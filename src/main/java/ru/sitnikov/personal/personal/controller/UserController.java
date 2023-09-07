package ru.sitnikov.personal.personal.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.model.UserModel;
import ru.sitnikov.personal.personal.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
            userService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody UserDto user) {
        if (user.getId() == null || user.getId() == 0) {
            return new ResponseEntity("У пользователя нет айдишника", HttpStatus.NOT_ACCEPTABLE);
        }
        userService.update(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/lastname/{lastname}")
    public List<UserModel> selectUsersByLastname(@PathVariable String lastname) {
        return userService.selectUsersByLastname(lastname);
    }

    @GetMapping("/selectByNameAndLastName")
    public ResponseEntity selectUsersByNameAndLastname(@RequestBody String name, String lastName) {

        return new ResponseEntity(userService.selectUsersByNameAndLastname(name, lastName), HttpStatus.OK);
    }


    @PostMapping("/all")
    public List<UserDto> getAll() {
        return userService.getAll();
    }
}
