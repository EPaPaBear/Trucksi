import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { UserDetailsComponent } from './users/user-details/user-details.component';
import { TravelComponent } from './travel/travel.component';
import { HystorytravelComponent } from './hystorytravel/hystorytravel.component';
import { HystorytravelDetailsComponent } from './hystorytravel/hystorytravel-details/hystorytravel-details.component';
/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */

@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent, UserDetailsComponent,TravelComponent, HystorytravelComponent, HystorytravelDetailsComponent],

  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }

