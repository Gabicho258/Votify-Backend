package pe.edu.unsa.votify_user.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.models.bd.User;
import pe.edu.unsa.votify_user.repository.ICredentialRepository;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class CredentialService implements ICredentialService {
    private  final ICredentialRepository credentialRepository;
    private static final String NUMEROS = "0123456789";
    private static final String LETRAS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
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
