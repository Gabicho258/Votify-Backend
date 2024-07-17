package pe.edu.unsa.votify_user.models.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public record CredentialResponseDTO(
        String _id,
        String user_id,
        String process_id,
        String password){

}
