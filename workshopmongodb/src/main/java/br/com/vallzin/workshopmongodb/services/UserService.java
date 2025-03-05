package br.com.vallzin.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vallzin.workshopmongodb.domain.User;
import br.com.vallzin.workshopmongodb.dto.UserDTO;
import br.com.vallzin.workshopmongodb.repository.UserRepository;
import br.com.vallzin.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: ID = " + id));
    }
	
	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		Optional<User> newObjOpt = repo.findById(obj.getId());
		User newObj = newObjOpt.get();
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(null, objDto.getName(), objDto.getEmail());
	}
	
}
