package pe.edu.unsa.votify_user.models.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@NoArgsConstructor
@Data
public class UsersCredentialRequestDto{
    String process_id;
    String process_title;
    List<VoterCredentialRequestDto> voters;
}
