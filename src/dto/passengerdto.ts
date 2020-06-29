import { UserDTO } from './userdto';
import { TruckDTO } from './truckdto';

export class PassengerDTO {

   id: number;
   name: string;
   surname: string;
   age: number;
   phone: string;
   user: UserDTO;
   truck: TruckDTO;
}