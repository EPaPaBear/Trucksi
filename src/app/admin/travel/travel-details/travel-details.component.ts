import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { TravelService } from 'src/service/travel.service';
import { TravelDTO } from 'src/dto/traveldto';
import { TruckDTO } from 'src/dto/truckdto';
import { TruckService } from 'src/service/truck.service';

/**
 * Questa component si occupa di mostrare i dettagli di un utente (in questo caso aggiunge solo l'ID
 * alle informazioni già mostrate nella tabella generale). L'annotation "@Input()" prende il valore di dto
 * dalla UsersComponent ( usando il binding [dto]) e nel template ne mostra i dettagli. Questa component 
 * non viene chiamata mediante routing ma viene mostrata solo quando dto non è nullo (usando la direttiva
 * *ngIf ).
 * 
 * @author Vittorio Valent
 * 
 * @see UsersComponent
 */
@Component({
  selector: 'app-travel-details',
  templateUrl: './travel-details.component.html',
  styleUrls: ['../travel.component.css']
})
export class TravelDetailsComponent extends AbstractCrudComponent<TravelDTO> implements OnInit {

  public userTypeOptions = [];

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: TravelDTO;

  constructor(travelService: TravelService) {
    super(travelService);
  }

  ngOnInit() {
  }

}
