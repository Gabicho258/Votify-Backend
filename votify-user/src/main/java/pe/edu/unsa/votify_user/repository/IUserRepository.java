package pe.edu.unsa.votify_user.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.unsa.votify_user.models.bd.User;

@Repository
public interface IUserRepository extends MongoRepository<User,String> {
}
