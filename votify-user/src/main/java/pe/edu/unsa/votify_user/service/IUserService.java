package pe.edu.unsa.votify_user.service;

import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserCreatedDTO;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.models.dto.UsersCredentialRequestDto;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    User registrarUsuario(User user);
    List<UserCreatedDTO> listarUsuarios();
    public Optional<UserCreatedDTO> obtenerUsuarioPorId(String id);
    User actualizarUsuario(String id, User user);


}
