package pe.edu.unsa.votify_user.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class UserProcessRequestDto{
    String process_id;
    String process_title;
    List<VoterRequestDto> voters;

}
