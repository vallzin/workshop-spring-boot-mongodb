package br.com.vallzin.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vallzin.workshopmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
