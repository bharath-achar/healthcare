import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Center } from './Center';
import { Test } from './Test';
import { Appointment } from './Appointment';


@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  appointments: Appointment[] = [];

  centers: Center[] = [];

  tests: Test[] = [];

  constructor(private http: HttpClient) { }

  backendURL = 'http://localhost:8080/healthcare';

  login(loginData) {
    return this.http.post<any>(`${this.backendURL}/login`, loginData);
  }

  center(centerData) {
    return this.http.post<any>(`${this.backendURL}/addDiagnoseCenter`, centerData);
  }

  test(testData) {
    return this.http.post<any>(`${this.backendURL}/addDiagnoseTest`, testData);
  }

  deletecenter(centerData) {
    return this.http.delete(`${this.backendURL}/deleteDiagnoseCenter/${centerData}`);
  }


  deleteTest(testData) {
    return this.http.delete(`${this.backendURL}/deleteDiagnoseTest/${testData}`);
  }


  allAppointments() {
    return this.http.get(`${this.backendURL}/allAppointments`)
      .subscribe(resData => {
        console.log(resData);
        const appointmentArray = [];
        for (const key in resData) {
          if (resData.hasOwnProperty(key)) {
            appointmentArray.push({ ...resData[key], pk: key });
          }
        }
        this.appointments = appointmentArray;
        console.log(this.appointments);
      });
  }

  setappointmentStatus(data) {
    return this.http.put(`${this.backendURL}/approveAppointment/${data.appointmentid}`, data);
  }


  getcenterData() {
    return this.http.get(`${this.backendURL}/getAllDiagnoseCenters`)
      .subscribe(resData => {
        console.log(resData);
        const centerArray = [];
        for (const key in resData) {
          if (resData.hasOwnProperty(key)) {
            centerArray.push({ ...resData[key], pk: key });
          }
        }
        this.centers = centerArray;
        console.log(this.centers);
      });
  }

  gettestData() {
    return this.http.get(`${this.backendURL}/getAllDiagnoseTest`)
      .subscribe(resData => {
        console.log(resData);
        const testArray = [];
        for (const key in resData) {
          if (resData.hasOwnProperty(key)) {
            testArray.push({ ...resData[key], pk: key });
          }
        }
        this.tests = testArray;
        console.log(this.tests);
      });
  }

  searchCenter(center) {
    return this.http.get<any>(`${this.backendURL}/searchCenter`, center);
  }


}
