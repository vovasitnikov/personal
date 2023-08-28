package ru.sitnikov.personal.personal.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sitnikov.personal.personal.dto.UserDto;
import ru.sitnikov.personal.personal.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping("/all")
    public List<UserDto> getAll() {
        return userService.getAll();
    }
}
