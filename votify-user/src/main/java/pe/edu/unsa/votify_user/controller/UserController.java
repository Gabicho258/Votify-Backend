package pe.edu.unsa.votify_user.controller;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserCreatedDTO;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.service.IUserService;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserRequestDto> registerUser(@RequestBody User user) {
        return new ResponseEntity(
                new UserCreatedDTO(userService.registrarUsuario(user)),
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<UserCreatedDTO> listUsers() {
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<UserRequestDto> getUser(@PathVariable String id) {
        return userService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{_id}")
    public ResponseEntity<UserCreatedDTO> updateUser(@PathVariable String _id, @RequestBody User user) {
        return new ResponseEntity<>(new UserCreatedDTO(userService.actualizarUsuario(_id, user))
                , HttpStatus.OK);
    }

}
