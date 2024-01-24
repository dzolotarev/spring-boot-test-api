package ru.dzolotarev.springbootapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.entity.UserEntity;
import ru.dzolotarev.springbootapi.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController // == @ResposeBody + @Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }
}
