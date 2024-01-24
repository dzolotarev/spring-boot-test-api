package ru.dzolotarev.springbootapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserDTO {

    @NotBlank(message = "Name can not be blank!") //need exception handler
    private String name;

    @NotNull(message = "Age can not be null!") //need exception handler
    private Integer age;
}
