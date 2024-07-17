package pe.edu.unsa.votify_user.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.models.dto.UserProcessRequestDto;
import pe.edu.unsa.votify_user.models.dto.UsersCredentialRequestDto;
import pe.edu.unsa.votify_user.models.dto.VoterCredentialRequestDto;
import pe.edu.unsa.votify_user.models.dto.VoterRequestDto;
import pe.edu.unsa.votify_user.repository.ICredentialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class CredentialService implements ICredentialService {
    private  final ICredentialRepository credentialRepository;
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
        UsersCredentialRequestDto responseUserCredential = new UsersCredentialRequestDto();
        responseUserCredential.setProcess_id(votifyUsers.getProcess_id());
        responseUserCredential.setProcess_title(votifyUsers.getProcess_title());
        List<VoterCredentialRequestDto> listVotantes = new ArrayList<>(); ;

        List<VoterRequestDto> listVotersOriginal = votifyUsers.getVoters();
        for (int i = 0; i < listVotersOriginal.size(); i++){
            Credential userCredential = new Credential();
            VoterCredentialRequestDto voter = new VoterCredentialRequestDto();
            VoterRequestDto voterOriginal = listVotersOriginal.get(i);
            voter.set_id(voterOriginal.get_id());
            voter.setUser_surname(voterOriginal.getUser_surname());
            voter.setUser_name(voterOriginal.getUser_name());
            voter.setEmail(voterOriginal.getEmail());
            userCredential.setUser_id(voter.get_id());
            userCredential.setProcess_id(votifyUsers.getProcess_id());
            Credential aprobado = registrarCredential(userCredential);
            voter.setCredential(aprobado.getPassword());
            listVotantes.add(voter);
        }
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
