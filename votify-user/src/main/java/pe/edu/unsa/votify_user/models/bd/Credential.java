package pe.edu.unsa.votify_user.models.bd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("credential")
public class Credential {
    @Id
    private String _id;
    @Field("user_id")
    private String user_id;
    @Field("process_id")
    private String process_id;
    private String password;
}
