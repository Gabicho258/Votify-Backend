package pe.edu.unsa.votify_user.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserProcessRequestDto;
import pe.edu.unsa.votify_user.models.dto.UsersCredentialRequestDto;
import pe.edu.unsa.votify_user.models.dto.VoterCredentialRequestDto;
import pe.edu.unsa.votify_user.models.dto.VoterRequestDto;
import pe.edu.unsa.votify_user.repository.ICredentialRepository;
import pe.edu.unsa.votify_user.repository.IUserRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@AllArgsConstructor
@Service
public class CredentialService implements ICredentialService {
    @Autowired
    private ICredentialRepository credentialRepository;
    @Autowired
    private IUserRepository userRepository;

    private static final String NUMEROS = "0123456789";
    private static final String LETRAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Transactional
    @Override
    public Credential registrarCredential(Credential usercredential) {
         List<Credential> credentials = listarCredential();
         String credencial = generadorDeCredenciales();

         while (true){
             if(obtenerCredentialPorPassword(credencial)) {
                 break;
             }
             else {
                 credencial = generadorDeCredenciales();
             }
         }
         usercredential.setPassword(credencial);
         return credentialRepository.save(usercredential);
    }

    @Override
    public List<Credential> listarCredential() {
        return credentialRepository.findAll();
    }

    @Override
    public boolean obtenerCredentialPorPassword(String password) {
        Credential aux = credentialRepository.findByPassword(password);
        if (aux == null) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public UsersCredentialRequestDto registrarUsuarios(UserProcessRequestDto votifyUsers) {
        List<VoterCredentialRequestDto> listVotantes = new ArrayList<>(); ;
        List<VoterRequestDto> listVotersOriginal = votifyUsers.getVoters();
        for (int i = 0; i < listVotersOriginal.size(); i++){
            VoterRequestDto voterOriginal = listVotersOriginal.get(i);
            Credential userCredential = new Credential();
            VoterCredentialRequestDto voter = new VoterCredentialRequestDto();
            Optional<User> usuarioExistente = userRepository.findByEmail(voterOriginal.getEmail());



            if(!usuarioExistente.isEmpty()){
                voter.setUser_surname(usuarioExistente.get().getUser_surname());
                voter.setUser_name(usuarioExistente.get().getUser_name());
                voter.setEmail(usuarioExistente.get().getEmail());
                voter.setDni(voterOriginal.getDni());
                userCredential.setUser_id(usuarioExistente.get().get_id());
                userCredential.setProcess_id(votifyUsers.getProcess_id());
                Credential aprobado = registrarCredential(userCredential);
                voter.setCredential(aprobado.getPassword());
                listVotantes.add(voter);
            }

            else{
                User usuarioNuevo = new User();
                usuarioNuevo.setUser_name(voterOriginal.getUser_name());
                usuarioNuevo.setUser_surname(voterOriginal.getUser_surname());
                usuarioNuevo.setRole("voter");
                usuarioNuevo.setEmail(voterOriginal.getEmail());
                usuarioNuevo.setDni(voterOriginal.getDni());
                usuarioNuevo.setIsactive(true);
                userRepository.save(usuarioNuevo);

                Optional<User> usuarioCreado = userRepository.findByEmail(usuarioNuevo.getEmail());
                voter.setUser_surname(usuarioNuevo.getUser_surname());
                voter.setUser_name(usuarioNuevo.getUser_name());
                voter.setEmail(usuarioNuevo.getEmail());
                voter.setDni(usuarioNuevo.getDni());
                userCredential.setUser_id(usuarioCreado.get().get_id());
                userCredential.setProcess_id(votifyUsers.getProcess_id());
                Credential aprobado = registrarCredential(userCredential);
                voter.setCredential(aprobado.getPassword());
                listVotantes.add(voter);
            }
        }
        UsersCredentialRequestDto responseUserCredential = new UsersCredentialRequestDto();
        responseUserCredential.setProcess_id(votifyUsers.getProcess_id());
        responseUserCredential.setProcess_title(votifyUsers.getProcess_title());
        responseUserCredential.setVoters(listVotantes);
        return responseUserCredential;
    }

    @Override
    public Credential buscarPorUserId(String user_id) {
        return null;
    }

    @Override
    public Credential buscarPorProccessId(String process_id) {
        return null;
    }

    public String generadorDeCredenciales(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(NUMEROS.length());
            sb.append(NUMEROS.charAt(index));
        }
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(LETRAS.length());
            sb.append(LETRAS.charAt(index));
        }

        return sb.toString();
    }
}
