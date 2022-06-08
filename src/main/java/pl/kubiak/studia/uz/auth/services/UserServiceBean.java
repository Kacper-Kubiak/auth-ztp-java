package pl.kubiak.studia.uz.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kubiak.studia.uz.auth.dtos.UserDTO;
import pl.kubiak.studia.uz.auth.models.User;
import pl.kubiak.studia.uz.auth.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserServiceBean implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO getUserByID(long id) {
        return new UserDTO().buildDto(this.getUserEntity(id));
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User userEntity : userList) {
            userDTOList.add((new UserDTO()).buildDto(userEntity));
        }
        return userDTOList;
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        return new UserDTO().buildDto(userRepository.save(userDto.toEntity()));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        userRepository.save(userDTO.toEntity());
        return userDTO;
    }

    public User getUserEntity(long id) {
        Optional<User> userEntity = userRepository.findById(id);
        return userEntity.orElse(null);
    }
}
