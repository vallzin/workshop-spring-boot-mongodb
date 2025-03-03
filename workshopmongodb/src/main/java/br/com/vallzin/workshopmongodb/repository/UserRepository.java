package br.com.vallzin.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vallzin.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
