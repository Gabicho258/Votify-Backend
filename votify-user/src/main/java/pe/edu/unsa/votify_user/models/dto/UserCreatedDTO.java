package pe.edu.unsa.votify_user.models.dto;

import pe.edu.unsa.votify_user.models.bd.User;

import java.util.Date;

public record UserCreatedDTO(
        String _id, String user_name, String role, String user_surname, String email, Date created_at, String dni,
        Boolean is_active
) {
    public UserCreatedDTO(User user){
        this(user.get_id(), user.getUser_name(), user.getRole(), user.getUser_surname(), user.getEmail(), user.getCreate_at(), user.getDni(),
                user.isIsactive());
    }


}
