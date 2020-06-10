import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-approve-appointment',
  templateUrl: './approve-appointment.component.html',
  styleUrls: ['./approve-appointment.component.css']
})
export class ApproveAppointmentComponent implements OnInit {

  constructor(private router: Router, private adminService: AdminServiceService) { }


  setAppointmentStatus(setStatus: NgForm) {
    console.log(setStatus.value);
    this.adminService.setappointmentStatus(setStatus.value).subscribe(data => {
      console.log(data);
      if (data === null) {
        console.log(data);
      } else {
        console.log('success');
        alert('Appointment has been successfully approved');
        this.router.navigate(['./adminhome']);
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
