package pe.edu.unsa.votify_user.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.service.IUserService;

import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    IUserService userService;

    @PostMapping("/create")
    public void registerUser(@RequestBody UserRequestDto userRequestDto) {
        userService.registrarUsuario(userRequestDto);
    }

    @GetMapping("/list")
    public Page<UserRequestDto> listUsers(@PageableDefault(size = 10) Pageable pageable) {
        return userService.listarUsuarios(pageable);
    }

    @GetMapping("/{id}")
    public Optional<UserRequestDto> getUser(@PathVariable String id) {
        return userService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.actualizarUsuario(user);
    }

}
