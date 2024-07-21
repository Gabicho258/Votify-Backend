package pe.edu.unsa.votify_user.models.dto.response;

public record CredentilUpdateUsedDTO(
        String _id,
        String user_id,
        String process_id,
        Boolean was_used,
        String message
) {

}
