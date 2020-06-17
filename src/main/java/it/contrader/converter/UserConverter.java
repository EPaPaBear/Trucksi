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
			if(userDTO.getPassenger() != null ) {
				user.setPassenger(passengerConverter.toEntity(userDTO.getPassenger()));
			}
			if(userDTO.getDriver() != null ) {
				user.setDriver(driverConverter.toEntity(userDTO.getDriver()));
			}
			
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());	
			user.setUsertype(userDTO.getUsertype());	
			user.setActive(userDTO.isActive());
			
			
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if(user!= null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
		
			if(user.getPassenger()!=null) {
				userDTO.setPassenger(passengerConverter.toDTO(user.getPassenger()));
			}
			if(user.getDriver()!=null) {
				userDTO.setDriver(driverConverter.toDTO(user.getDriver()));
			}
		
			userDTO.setUsername(user.getUsername());		
			userDTO.setPassword(user.getPassword());		
			userDTO.setUsertype(user.getUsertype());
			userDTO.setActive(user.isActive());
		}
		return userDTO;
	}

}
