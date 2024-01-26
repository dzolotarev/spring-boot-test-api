package ru.dzolotarev.springbootapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    List<UserDTO> toUserDTOs(List<UserEntity> userEntities);

    UserDTO toUserDTO(UserEntity userEntity);

    UserEntity toUserEntity(UserDTO userDTO);
}
