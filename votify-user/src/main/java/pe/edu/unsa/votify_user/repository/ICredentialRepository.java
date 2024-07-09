package pe.edu.unsa.votify_user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unsa.votify_user.models.bd.Credential;


@Repository
public interface ICredentialRepository extends MongoRepository<Credential, String> {
    Credential findByPassword(String password);
}
