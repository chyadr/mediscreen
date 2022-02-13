import { Component, OnInit } from '@angular/core';
import { PatientService } from '../patient.service';
import { FormBuilder } from '@angular/forms';
import { IPatient, Patient } from 'src/app/model/patient.model';
import { ActivatedRoute } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { IError } from 'src/app/model/error.model';
import { catchError } from 'rxjs/operators';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrls: ['./update-patient.component.css']
})
export class UpdatePatientComponent implements OnInit {
  patient : IPatient = new Patient();
  public errors: IError[] = [];

  constructor(protected patientService: PatientService,
    protected activatedRoute : ActivatedRoute) { }

  ngOnInit(): void {

    this.activatedRoute.data.subscribe(({patient}) =>{
      this.patient = patient;
    });
  }

  save(){
    
    if (this.patient.id !== undefined){
      this.subscribetoSaveResponse(this.patientService.updatePatient(this.patient));
    } else {
      this.subscribetoSaveResponse(this.patientService.createPatient(this.patient));

    }
  }

  previousState(){
    window.history.back();
  }

  protected subscribetoSaveResponse (result : Observable<HttpResponse<IPatient>>){
    result.subscribe((res : HttpResponse<IPatient>) =>this.onSaveSuccess(),(err:HttpErrorResponse) => {
       this.errors = err.error.errors;
      
    });
  }
  protected onSaveSuccess(){
    this.previousState();
  }

  
 

}
