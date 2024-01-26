package ru.dzolotarev.springbootapi.service;

import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.entity.UserEntity;
import ru.dzolotarev.springbootapi.mapper.UserMapper;
import ru.dzolotarev.springbootapi.repository.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getAll() {
        return userMapper.toUserDTOs(userRepository.findAll());
    }

    public List<UserDTO> getByAge(Integer age) {
        return userMapper.toUserDTOs(userRepository.findUserEntityByAge(age));
    }

    public void save(UserDTO userDTO) {
        userRepository.save(userMapper.toUserEntity(userDTO));
    }

    public UserDTO updateById(Long id, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        if (StringUtils.isNotBlank(userDTO.getName())) {
            userEntity.setName(userDTO.getName());
        }
        if (!Objects.isNull(userDTO.getAge())) {
            userEntity.setAge(userDTO.getAge());
        }
        return userMapper.toUserDTO(userRepository.save(userEntity));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getAllAndOrderByAgeDesc() {
        return userMapper.toUserDTOs(userRepository.findAllAndOrderByAgeDesc());
    }
}
