package pe.edu.unsa.votify_user.models.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoterCredentialRequestDto{
    String _id;
    String user_name;
    String user_surname;
    String email;
    String credential;
}
