package pl.kubiak.studia.uz.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kubiak.studia.uz.auth.dtos.UserDTO;
import pl.kubiak.studia.uz.auth.models.User;
import pl.kubiak.studia.uz.auth.services.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable long clientId) {
        return userService.getUserByID(clientId);
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody UserDTO userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/users/{id}")
    public UserDTO putUser(@PathVariable long clientId, UserDTO userDTO) {
        userDTO.setClientId(clientId);
        return userService.updateUser(userDTO);
    }
}
