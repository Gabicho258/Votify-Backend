package pe.edu.unsa.votify_user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserCreatedDTO;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.repository.IUserRepository;


import java.util.ArrayList;
import java.util.List;
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
        newUser.setIsactive(true);
        return userRepository.save(newUser);
    }

    @Override
    public List<UserCreatedDTO> listarUsuarios() {

        List<UserCreatedDTO> createdDTOs = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            createdDTOs.add(new UserCreatedDTO(user));
        }
        return createdDTOs;
    }

    @Override
    public Optional<UserCreatedDTO> obtenerUsuarioPorId(String id) {
        return userRepository.findById(id).map(UserCreatedDTO::new);
    }

    @Override
    public User actualizarUsuario(String id, UserCreatedDTO user) {
        User userUpdate = userRepository.findById(id).orElse(null);
        if (userUpdate == null) {
            throw new RuntimeException("No existe el usuario con id " + id);
        }

        if(user.user_name() != null ){
            userUpdate.setUser_name(user.user_name());
        }

        if (user.user_surname() != null){
            userUpdate.setUser_surname(user.user_surname());
        }

        if(user.role() != null){
            userUpdate.setRole(user.role());
        }
        if(user.email() != null){
            userUpdate.setEmail(user.email());
        }
        if(user.dni() != null){
            userUpdate.setDni(user.dni());
        }
        if (user.created_at() != null) {
            userUpdate.setCreate_at(user.created_at());
        }

        if(user.is_active() != null){
            userUpdate.setIsactive(user.is_active());
        }

        return userRepository.save(userUpdate);
    }

    @Override
    public User obtenerUsuarioPorEmail(String email) {

        return userRepository.findByEmail(email).get();
    }
}
