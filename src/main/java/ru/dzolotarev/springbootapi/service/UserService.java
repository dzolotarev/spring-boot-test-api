package ru.dzolotarev.springbootapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.mapper.UserMapper;
import ru.dzolotarev.springbootapi.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    public List<UserDTO> getUsersByAge(Integer age) {
        return userMapper.toUserDTOs(userRepository.findUserEntityByAge(age));
    }

    public void saveUser(UserDTO userDTO) {
        userRepository.save(userMapper.toUserEntity(userDTO));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
