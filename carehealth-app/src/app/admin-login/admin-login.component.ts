import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AdminServiceService } from '../admin-service.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }

  loginService(loginForm: NgForm) {
    this.adminService.login(loginForm.value).subscribe(data => {
      console.log(data);
      if (data == null) {
        alert('Invalid credentials...');
      } else {
        if (data.userType === 'admin') {
          console.log('admin');
          localStorage.setItem('admin', data);
          alert('Logged in as Admin')
          this.router.navigateByUrl('/adminhome');
        } else {
          alert('Invalid credentials');
        }
      }
    }, err => {
      alert('Something went wrong.. Please restart...')
      console.log('ERROR. LOGIN FAILED.');
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
