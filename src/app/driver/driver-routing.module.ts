import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DriverLayoutComponent } from '../layout/driver-layout/driver-layout.component';
import { DriverDashboardComponent } from './driver-dashboard/driver-dashboard.component';
import { TruckComponent } from './truck/truck.component';

import { AuthGuard } from '../../guard/auth/auth.guard';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati). Si osservi il Guard "canActivate: [AuthGuard]" che protegge le routes
 * del'ADMIN dagli altri utenti.
 * 
 * @author Vittorio Valent
 * 
 * @see DriverLayoutComponent
 * @see AuthGuard
 * @see layout
 */
const routes: Routes = [
   {
      path: 'driver-dashboard', component: DriverLayoutComponent, canActivate: [AuthGuard], children: [
         { path: '', component: DriverDashboardComponent },
         { path: 'truck', component: TruckComponent }
      ]
   }
];

@NgModule({
   imports: [RouterModule.forChild(routes)],
   exports: [RouterModule]
})
export class DriverRoutingModule { }