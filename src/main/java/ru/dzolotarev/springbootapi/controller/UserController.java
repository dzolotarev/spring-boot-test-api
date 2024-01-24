package ru.dzolotarev.springbootapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController // == @ResposeBody + @Controller
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping("getall") // http://localhost:8080/users/getall GET
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("getbyage") // http://localhost:8080/users/getbyage?age=? GET
    public List<UserDTO> getByAge(@RequestParam Integer age) {
        return userService.getUsersByAge(age);
    }

    @PostMapping // http://localhost:8080/users POST and BODY {"name":"John Smith","age":"35"} and @Valid - validation
    public void saveUser(@RequestBody @Valid UserDTO userDTO) {
        userService.saveUser(userDTO);
    }
}
