import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-all-appointments',
  templateUrl: './all-appointments.component.html',
  styleUrls: ['./all-appointments.component.css']
})
export class AllAppointmentsComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private route: Router) { }

  logout() {
    localStorage.clear();
    this.route.navigateByUrl('/');
  }

  ngOnInit() {
    this.adminService.allAppointments();
  }

}
