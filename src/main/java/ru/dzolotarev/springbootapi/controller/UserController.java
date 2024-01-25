package ru.dzolotarev.springbootapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dzolotarev.springbootapi.dto.UserDTO;
import ru.dzolotarev.springbootapi.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@RestController // == @ResposeBody + @Controller
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping // http://localhost:8080/users GET
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping(params = "age")  // http://localhost:8080/users?age=22 GET
    public List<UserDTO> getByAge(@RequestParam Integer age) {
        return userService.getUsersByAge(age);
    }

    @PostMapping // http://localhost:8080/users POST and BODY {"name":"John Smith","age":"35"} and @Valid - validation
    public void save(@RequestBody @Valid UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

    @DeleteMapping("{ID}") // http://localhost:8080/users/{ID} DELETE
    public void deleteById(@PathVariable("ID") Long id) {
        userService.delete(id);
    }


}
