package pe.edu.unsa.votify_user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;

import java.util.Optional;


public interface IUserService {
    User registrarUsuario(UserRequestDto user);
    Page<UserRequestDto> listarUsuarios(Pageable paginacion);
    public Optional<UserRequestDto> obtenerUsuarioPorId(String id);
    User actualizarUsuario(User user);


}
