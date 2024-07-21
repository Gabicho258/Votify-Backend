package pe.edu.unsa.votify_user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unsa.votify_user.models.bd.Credential;

import java.util.List;


@Repository
public interface ICredentialRepository extends MongoRepository<Credential, String> {
    Credential findByPassword(String password);
    Credential findBy_id(String id);
    List<Credential> findByProcess(String procces_id);
    List<Credential> findByUser(String user);

}
