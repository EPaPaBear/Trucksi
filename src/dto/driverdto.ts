import { UserDTO } from './userdto';
import { TruckDTO } from './truckdto';

export class DriverDTO {

   id: number;
   name: string;
   surname: string;
   driverLicense: string;
   phone: string;
   age: number;
   truckList: TruckDTO[];
   user: UserDTO;
}