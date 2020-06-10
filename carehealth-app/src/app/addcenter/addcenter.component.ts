import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addcenter',
  templateUrl: './addcenter.component.html',
  styleUrls: ['./addcenter.component.css']
})
export class AddcenterComponent implements OnInit {

  constructor(private router: Router, private adminService: AdminServiceService) { }

  addCenter(centerForm: NgForm) {
    this.adminService.center(centerForm.value).subscribe(data => {
      console.log(centerForm.value);
      console.log(data);
      if (data != null) {
        alert('Center has been successfully added');
        this.router.navigateByUrl('/addtest');
      } else {
        alert('Center has not been added..')
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
