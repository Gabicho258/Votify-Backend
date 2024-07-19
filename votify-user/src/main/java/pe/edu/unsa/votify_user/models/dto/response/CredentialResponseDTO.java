package pe.edu.unsa.votify_user.models.dto.response;

public record CredentialResponseDTO(
        String _id,
        String user_id,
        String email,
        String process_id,
        String password){

}
