import { Usertype } from './usertype';
import { DriverDTO } from './driverdto';
import { PassengerDTO } from './passengerdto';
/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend.
 *
 * @see Usertype
 *
 * @author Vittorio Valent
 */
export class UserDTO {

   id: number;

   username: string;

   password: string;

   usertype: Usertype;

   driver: DriverDTO;

   passenger: PassengerDTO;

   active = true;

   setid(id:number){
     this.id = id;
   }


}

