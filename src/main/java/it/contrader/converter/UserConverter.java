package it.contrader.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO>{

	@Autowired
	private PassengerConverter passengerConverter;
	
	@Autowired
	private DriverConverter driverConverter;

	
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if(userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());	
			user.setUsertype(userDTO.getUsertype());	
			user.setActive(userDTO.isActive());
			user.setPassenger(passengerConverter.toEntityS(userDTO.getPassenger()));  
			user.setDriver(driverConverter.toEntityS(userDTO.getDriver()));
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) { 
		UserDTO userDTO = null;
		if(user!= null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());		
			userDTO.setPassword(user.getPassword());		
			userDTO.setUsertype(user.getUsertype());
			userDTO.setActive(user.isActive());
			userDTO.setPassenger(passengerConverter.toDTOS(user.getPassenger())); 
			userDTO.setDriver(driverConverter.toDTOS(user.getDriver()));
			
		}
		return userDTO;
	}
	
	@Override
	public User toEntityS(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword()); 
			user.setUsertype(userDTO.getUsertype());
			user.setActive(userDTO.isActive());
			
		}
		return user;
	}

	@Override
	public UserDTO toDTOS(User user) { 
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());	
			userDTO.setActive(user.isActive());
			userDTO.setUsertype(user.getUsertype());
		}
		return userDTO;
	}
	

}
