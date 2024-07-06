package pe.edu.unsa.votify_user.models.bd;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("user")
public class User {
    @Id
    private String user_id;
    private String role;
    private String user_name;
    private String user_surname;
    private String password;
    private String email;
    private Date create_at;
    private String dni;
    private boolean isactive;
}
