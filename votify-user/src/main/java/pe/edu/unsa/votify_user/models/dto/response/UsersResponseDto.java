package pe.edu.unsa.votify_user.models.dto.response;

import lombok.*;

import java.util.List;


@NoArgsConstructor
@Data
public class UsersResponseDto {
    String process_id;
    String process_title;
    List<VoterResponseDTO> voters;
}
