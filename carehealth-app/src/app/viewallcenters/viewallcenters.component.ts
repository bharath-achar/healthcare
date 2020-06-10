import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-viewallcenters',
  templateUrl: './viewallcenters.component.html',
  styleUrls: ['./viewallcenters.component.css']
})
export class ViewallcentersComponent implements OnInit {
  selectviewallcenters: any;

  constructor(private adminService: AdminServiceService, private router: Router) { }

  delete(center) {
    this.adminService.deletecenter(center.centerId).subscribe(resData => {
      console.log(resData);
      this.adminService.getcenterData();

      if (resData === true) {
        this.router.navigateByUrl('/viewallcenters');
      } else {
        alert('Data cannot be deleted');
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
    this.adminService.getcenterData();
  }

}
