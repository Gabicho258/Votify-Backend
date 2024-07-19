package pe.edu.unsa.votify_user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unsa.votify_user.models.bd.User;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {

    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    User findBy_id(String id);
}
