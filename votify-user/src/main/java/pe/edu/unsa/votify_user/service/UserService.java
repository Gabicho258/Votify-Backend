package pe.edu.unsa.votify_user.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.repository.IUserRepository;

import java.util.Optional;



@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Override
    public User registrarUsuario(UserRequestDto user) {
        User newUser = new User();
        newUser.setUser_id(user.id());
        newUser.setUser_name(user.user_name());
        newUser.setRole(user.role());
        newUser.setUser_surname(user.user_surname());
        newUser.setEmail(user.email());
        newUser.setDni(user.dni());
        newUser.setIsactive(true);
        return userRepository.save(newUser);
    }

    @Override
    public Page<UserRequestDto> listarUsuarios(Pageable paginacion) {
        return userRepository.findAll(paginacion).map(UserRequestDto::new);
    }

    @Override
    public Optional<UserRequestDto> obtenerUsuarioPorId(String id) {
        return userRepository.findById(id).map(UserRequestDto::new);
    }

    @Override
    public User actualizarUsuario(User user) {
        return userRepository.save(user);
    }
}
