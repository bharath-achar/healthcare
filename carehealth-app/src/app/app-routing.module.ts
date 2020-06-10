import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddcenterComponent } from './addcenter/addcenter.component';
import { AddtestComponent } from './addtest/addtest.component';
import { AllAppointmentsComponent } from './all-appointments/all-appointments.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';
import { ViewallcentersComponent } from './viewallcenters/viewallcenters.component';
import { ViewalltestsComponent } from './viewalltests/viewalltests.component';
import { ContactComponent } from './contact/contact.component';
import { AboutComponent } from './about/about.component';
import { BlogComponent } from './blog/blog.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'adminlogin', component: AdminLoginComponent },
  { path: 'adminhome', component: AdminHomeComponent, canActivate: [AuthGuard] },
  { path: 'addcenter', component: AddcenterComponent, canActivate: [AuthGuard] },
  { path: 'addtest', component: AddtestComponent, canActivate: [AuthGuard] },
  { path: 'allappointments', component: AllAppointmentsComponent, canActivate: [AuthGuard] },
  { path: 'approveappointment', component: ApproveAppointmentComponent, canActivate: [AuthGuard] },
  { path: 'viewallcenters', component: ViewallcentersComponent, canActivate: [AuthGuard] },
  { path: 'viewalltests', component: ViewalltestsComponent, canActivate: [AuthGuard] },
  { path: 'contact', component: ContactComponent },
  { path: 'about', component: AboutComponent },
  { path: 'blog', component: BlogComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
