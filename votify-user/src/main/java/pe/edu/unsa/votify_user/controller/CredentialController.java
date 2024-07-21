package pe.edu.unsa.votify_user.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.models.dto.response.CredentialResponseDTO;
import pe.edu.unsa.votify_user.models.dto.request.UserProcessRequestDto;
import pe.edu.unsa.votify_user.models.dto.response.CredentilUpdateUsedDTO;
import pe.edu.unsa.votify_user.models.dto.response.UsersResponseDto;
import pe.edu.unsa.votify_user.service.ICredentialService;

import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping(("/api/v1/credential"))
public class CredentialController {
    ICredentialService credentialService;

    @GetMapping("/list")
    public ResponseEntity<List<Credential>> getCredentials() {
        return new ResponseEntity<>(credentialService.listarCredential(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Credential> createCredential(@RequestBody Credential credential) {
        return new ResponseEntity<>(credentialService.registrarCredential(credential), HttpStatus.CREATED);
    }

    @PostMapping("/create/users")
    public ResponseEntity<UsersResponseDto> createCredentialsUser(@RequestBody UserProcessRequestDto requestVote) {
        return new ResponseEntity<>(credentialService.registrarUsuarios(requestVote), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<CredentialResponseDTO>> getCredentialsUser(@PathVariable String id) {
        return new ResponseEntity<>(credentialService.buscarPorUserId(id), HttpStatus.OK);
    }

    @GetMapping("/process/{id}")
    public ResponseEntity<List<CredentialResponseDTO>> getCredentialsProcess(@PathVariable String id) {
        return new ResponseEntity<>(credentialService.buscarPorProccessId(id), HttpStatus.OK);
    }

    @PutMapping("/update-used/{id}")
    public ResponseEntity<CredentilUpdateUsedDTO> updateCredentialUsed(@PathVariable String id) {
        return new ResponseEntity<>(credentialService.actualizarCredencialUsada(id), HttpStatus.OK);
    }

}
