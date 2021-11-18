package br.com.fiap.vida_na_agua.repository;

import br.com.fiap.vida_na_agua.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{username : ?0}")
    Optional<User> findByUsername(String username);
}
