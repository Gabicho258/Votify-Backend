package pe.edu.unsa.votify_user.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VoterRequestDto{
    String dni;
    String user_name;
    String user_surname;
    String email;
}
