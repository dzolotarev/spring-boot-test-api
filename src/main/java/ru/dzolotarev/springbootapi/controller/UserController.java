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
        return userService.getAll();
    }

    @GetMapping("byAgeDesc")
    public List<UserDTO> getALlByAgeDesc() {
        return userService.getAllAndOrderByAgeDesc();
    }

    @GetMapping(params = "age")  // http://localhost:8080/users?age=22 GET
    public List<UserDTO> getByAge(@RequestParam("get") Integer age) {
        return userService.getByAge(age);
    }

    @PostMapping // http://localhost:8080/users POST and BODY {"name":"John Smith","age":"35"} and @Valid - validation
    public void save(@RequestBody @Valid UserDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping(params = "id") // http://localhost:8080/users?id=123 PUT and BODY {"name":"John Smith","age":"35"}
    public UserDTO updateById(@RequestParam("id") Long id,
                              @RequestBody @Valid UserDTO userDTO) {
        return userService.updateById(id, userDTO);
    }

    @DeleteMapping("{id}") // http://localhost:8080/users/{ID} DELETE
    public void deleteById(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
