package pe.edu.unsa.votify_user.service;

import pe.edu.unsa.votify_user.models.bd.Credential;

import pe.edu.unsa.votify_user.models.dto.CredentialResponseDTO;
import pe.edu.unsa.votify_user.models.dto.UserProcessRequestDto;

import pe.edu.unsa.votify_user.models.dto.UsersCredentialRequestDto;

import java.util.List;

public interface ICredentialService {
   Credential registrarCredential(Credential user);
   List<Credential> listarCredential();
   boolean obtenerCredentialPorPassword(String id);
   UsersCredentialRequestDto registrarUsuarios(UserProcessRequestDto votifyUserCredential);
   List<CredentialResponseDTO> buscarPorUserId(String user_id);
   List<CredentialResponseDTO> buscarPorProccessId(String process_id);
}
