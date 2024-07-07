package pe.edu.unsa.votify_user.service;


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
    public User registrarUsuario(User user) {
        User newUser = new User();
        newUser.setUser_name(user.getUser_name());
        newUser.setRole(user.getRole());
        newUser.setUser_surname(user.getUser_surname());
        newUser.setEmail(user.getEmail());
        newUser.setDni(user.getDni());
        newUser.set_active(true);
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
    public User actualizarUsuario(String id, User user) {
        User userUpdate = userRepository.findById(id).orElse(null);
        if (userUpdate == null) {
            return null;
        }
        userUpdate.setUser_name(user.get_id());
        if (user.getUser_surname() != null){
            userUpdate.setUser_surname(user.getUser_surname());
        }
        if(user.getUser_name() != null ){
            userUpdate.setUser_name(user.getUser_name());
        }
        if(user.getRole() != null){
            userUpdate.setRole(user.getRole());
        }
        if(user.getEmail() != null){
            userUpdate.setEmail(user.getEmail());
        }
        if(user.getDni() != null){
            userUpdate.setDni(user.getDni());
        }
        if (user.getCreate_at() != null) {
            userUpdate.setCreate_at(user.getCreate_at());
        }
        if (user.is_active()){
            userUpdate.set_active(user.is_active());
        }
        return userRepository.save(userUpdate);
    }
}
