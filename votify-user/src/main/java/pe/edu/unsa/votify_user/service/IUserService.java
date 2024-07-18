package pe.edu.unsa.votify_user.service;

import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.response.UserResponseDTO;

import java.util.List;
import java.util.Optional;


public interface IUserService {
    User registrarUsuario(User user);
    List<UserResponseDTO> listarUsuarios();
    public Optional<UserResponseDTO> obtenerUsuarioPorId(String id);
    User actualizarUsuario(String id, UserResponseDTO user);
    User obtenerUsuarioPorEmail(String email);


}
