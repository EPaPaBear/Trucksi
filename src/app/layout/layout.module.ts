import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { AdminLayoutComponent } from "./admin-layout/admin-layout.component";
import { AdminMenuComponent } from "./admin-layout/admin-menu/admin-menu.component";
import { HeaderComponent } from "./header/header.component";
import { RouterModule } from "@angular/router";
import { HystorytravelMenuComponent } from "./admin-layout/hystorytravel-menu/hystorytravel-menu.component";
import { DriverLayoutComponent } from "./driver-layout/driver-layout.component";
import { DriverMenuComponent } from "./driver-layout/driver-menu/driver-menu.component";
//import { UsertypeComponent } from './admin-layout/admin-layout/usertype/usertype.component';
import { SidebarbrandComponent } from './admin-layout/admin-layout/sidebarbrand/sidebarbrand.component';
import { CitymenuComponent } from './admin-layout/admin-menu/citymenu/citymenu.component';
import { UsermenuComponent } from './admin-layout/admin-menu/usermenu/usermenu.component';
import { DrivermenuComponent } from './admin-layout/admin-menu/drivermenu/drivermenu.component';
import { TruckmenuComponent } from './admin-layout/admin-menu/truckmenu/truckmenu.component';
import { TrevelmenuComponent } from './admin-layout/admin-menu/trevelmenu/trevelmenu.component';
import { HystorytravelmenuComponent } from './admin-layout/admin-menu/hystorytravelmenu/hystorytravelmenu.component';
import { OtherslayoutcomponentComponent } from './admin-layout/otherslayoutcomponent/otherslayoutcomponent.component';
import { ToolbarComponent } from './admin-layout/toolbar/toolbar.component';

/**
 * Modulo di layout. Viene caricato nel rputer outlet padre e poi
 * non viene più ricaricato. Quando clicchiamo su un link ricarichiamo solo l'outlet
 * che sta dentro AdminLayoutComponent
 *
 * @author Vittorio Valent
 *
 * @see AdminLayoutComponent
 */
@NgModule({
  declarations: [
    AdminLayoutComponent,
    AdminMenuComponent,
    HeaderComponent,
    HystorytravelMenuComponent,
    DriverLayoutComponent,
    DriverMenuComponent,
 /*   UsertypeComponent,*/
    SidebarbrandComponent,
 CitymenuComponent,
 UsermenuComponent,
 DrivermenuComponent,
 TruckmenuComponent,
 TrevelmenuComponent,
 HystorytravelmenuComponent,
 OtherslayoutcomponentComponent,
 ToolbarComponent
  ],
  imports: [CommonModule, RouterModule],
  exports: [
    /*UsertypeComponent,*/
    SidebarbrandComponent,
    CitymenuComponent,
    UsermenuComponent,
    DrivermenuComponent,
    TruckmenuComponent,
    TrevelmenuComponent,
    HystorytravelmenuComponent,
    OtherslayoutcomponentComponent,
    ToolbarComponent],
})
export class LayoutModule {}
