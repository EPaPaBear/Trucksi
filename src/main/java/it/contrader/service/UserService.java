package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * Estende AbstractService con parametri {@link User} e {@link UserDTO}.
 * Implementa il metodo di login ed eredita quelli Abstract.
 * 
 * @author Vittorio Valent
 * @author Girolamo Murdaca
 * 
 * @see AbstractService
 * @see ServiceDTO
 */
@Service
public class UserService extends AbstractService<User, UserDTO> {

	// ALL crud methods in AbstractService

	// LOGIN method
	public UserDTO findByUsernameAndPassword(String username, String password) {
		return converter.toDTO(((UserRepository) repository).findByUsernameAndPassword(username, password));
	}
	
	public User convertUserDTO(UserDTO userDTO) {
		return converter.toEntity(userDTO);
	}

}
