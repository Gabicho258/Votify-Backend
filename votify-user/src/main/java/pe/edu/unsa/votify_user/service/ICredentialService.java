package pe.edu.unsa.votify_user.service;

import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserProcessRequestDto;
import pe.edu.unsa.votify_user.models.dto.UserRequestDto;
import pe.edu.unsa.votify_user.models.dto.UsersCredentialRequestDto;

import java.util.List;
import java.util.Optional;

public interface ICredentialService {
   Credential registrarCredential(Credential user);
   List<Credential> listarCredential();
   boolean obtenerCredentialPorPassword(String id);
   UsersCredentialRequestDto registrarUsuarios(UserProcessRequestDto votifyUserCredential);
}
