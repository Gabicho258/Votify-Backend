package pe.edu.unsa.votify_user.service;

import pe.edu.unsa.votify_user.models.bd.Credential;

import pe.edu.unsa.votify_user.models.dto.response.CredentialResponseDTO;
import pe.edu.unsa.votify_user.models.dto.request.UserProcessRequestDto;

import pe.edu.unsa.votify_user.models.dto.response.CredentilUpdateUsedDTO;
import pe.edu.unsa.votify_user.models.dto.response.UsersResponseDto;

import java.util.List;

public interface ICredentialService {
   Credential registrarCredential(Credential user);
   List<Credential> listarCredential();
   boolean obtenerCredentialPorPassword(String id);
   UsersResponseDto registrarUsuarios(UserProcessRequestDto votifyUserCredential);
   List<CredentialResponseDTO> buscarPorUserId(String user_id);
   List<CredentialResponseDTO> buscarPorProccessId(String process_id);
   CredentilUpdateUsedDTO actualizarCredencialUsada(String id);
}
