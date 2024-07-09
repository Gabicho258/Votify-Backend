package pe.edu.unsa.votify_user.models.dto;

import pe.edu.unsa.votify_user.models.bd.User;

import java.util.Date;


public record UserRequestDto (String id, String user_name,  String role, String user_surname, String email, Date created_at, String dni) {

    public UserRequestDto(User user){
        this(user.get_id(), user.getUser_name(), user.getRole(), user.getUser_surname(), user.getEmail(), user.getCreate_at(), user.getDni());
    }

}
