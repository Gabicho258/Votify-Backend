package pe.edu.unsa.votify_user.models.bd;



import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String _id;
    private String role;
    private String user_name;
    private String user_surname;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date create_at = new Date();
    private String dni;
    private boolean isactive;


}
