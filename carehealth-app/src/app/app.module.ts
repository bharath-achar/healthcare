import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddcenterComponent } from './addcenter/addcenter.component';
import { AddtestComponent } from './addtest/addtest.component';
import { ApproveAppointmentComponent } from './approve-appointment/approve-appointment.component';
import { AllAppointmentsComponent } from './all-appointments/all-appointments.component';
import { ViewalltestsComponent } from './viewalltests/viewalltests.component';
import { ViewallcentersComponent } from './viewallcenters/viewallcenters.component';
import { AboutComponent } from './about/about.component';
import { BlogComponent } from './blog/blog.component';
import { ContactComponent } from './contact/contact.component';
import { AuthService } from './auth.service';
import { AuthGuard } from './auth.guard';
import { FilterCenterPipesPipe } from './filter-center-pipes.pipe';
import { FilterTestPipe } from './filter-test.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminLoginComponent,
    AdminHomeComponent,
    AddcenterComponent,
    AddtestComponent,
    ApproveAppointmentComponent,
    AllAppointmentsComponent,
    ViewalltestsComponent,
    ViewallcentersComponent,
    AboutComponent,
    BlogComponent,
    ContactComponent,
    FilterCenterPipesPipe,
    FilterTestPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
