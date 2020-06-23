import { DriverDTO } from './driverdto';

export class TruckDTO {

  id: number;
  licensePlate: string;
  model: string;
  driver: DriverDTO;
}
