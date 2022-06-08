package pl.kubiak.studia.uz.auth.services;

import org.springframework.stereotype.Service;
import pl.kubiak.studia.uz.auth.dtos.UserDTO;
import pl.kubiak.studia.uz.auth.models.User;

import java.util.List;

@Service
public interface UserService {
    UserDTO getUserByID(long id);
    List<UserDTO> getUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
}
