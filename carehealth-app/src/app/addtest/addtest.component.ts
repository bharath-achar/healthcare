import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormArray, NgForm } from '@angular/forms';
import { AdminServiceService } from '../admin-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addtest',
  templateUrl: './addtest.component.html',
  styleUrls: ['./addtest.component.css']
})
export class AddtestComponent implements OnInit {

  constructor(private adminService: AdminServiceService, private router: Router) { }

  form: FormGroup;
  options;


  addTest(testForm: NgForm) {
    this.adminService.test(testForm.value).subscribe(data => {
      console.log(data);
      if (data != null) {
        alert('Test has been successfully added');
        this.router.navigateByUrl('/adminhome');
      } else {
        alert('Test has not been added..')
      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }

}
