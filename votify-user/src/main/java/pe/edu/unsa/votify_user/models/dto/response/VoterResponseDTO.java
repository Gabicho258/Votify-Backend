package pe.edu.unsa.votify_user.models.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoterResponseDTO {
    String dni;
    String user_name;
    String user_surname;
    String email;
    String credential;
}
