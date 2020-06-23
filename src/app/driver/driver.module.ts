import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DriverRoutingModule } from './driver-routing.module';
import { DriverDashboardComponent } from './driver-dashboard/driver-dashboard.component';
import { TruckComponent } from './truck/truck.component';
import { TruckDetailsComponent } from './truck/truck-details/truck-details.component';

@NgModule({
  declarations: [DriverDashboardComponent, TruckComponent, TruckDetailsComponent],
  imports: [
    CommonModule,
    DriverRoutingModule,
    FormsModule
  ]
})
export class DriverModule { }
