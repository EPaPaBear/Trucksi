import { UserDTO } from 'src/dto/userdto'; 

export class DriverDTO {
  
   id :number;
   name : String;
   surname: String;
   driverLicense: String;
   phone :String;
   age:number;

   //trucklise:TruckDTO;
   user:UserDTO;
}
/*
private long id;
	
	private String name;
	
	private String surname;
	
	private String driverLicense;
	
	private String phone; 
	
	private int age; 
	
	//private List<TruckDTO> truckList;
	
	private UserDTO user;
	



*/