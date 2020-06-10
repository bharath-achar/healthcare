import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewalltests',
  templateUrl: './viewalltests.component.html',
  styleUrls: ['./viewalltests.component.css']
})
export class ViewalltestsComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }


  delete(test) {
    this.adminService.deleteTest(test.testId).subscribe(resData => {
      console.log(resData);
      this.adminService.gettestData();
      if (resData === true) {
        this.router.navigateByUrl('/viewalltests');
      } else {
        alert('Data cannot be deleted');
      }
    }, err => {
      console.log(err);
    });
  }


  ngOnInit() {
    this.adminService.gettestData();
  }

}
