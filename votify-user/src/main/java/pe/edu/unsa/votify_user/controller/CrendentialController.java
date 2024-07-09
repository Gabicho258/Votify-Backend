package pe.edu.unsa.votify_user.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.unsa.votify_user.models.bd.Credential;
import pe.edu.unsa.votify_user.service.ICredentialService;

import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping(("/api/v1/credential"))
public class CrendentialController {
    ICredentialService credentialService;

    @GetMapping("/list")
    public ResponseEntity<List<Credential>> getCredentials() {
        return new ResponseEntity<>(credentialService.listarCredential(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Credential> createCredential(@RequestBody Credential credential) {
        return new ResponseEntity<>(credentialService.registrarCredential(credential), HttpStatus.CREATED);
    }

}
