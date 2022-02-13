import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IPatient, Patient } from 'src/app/model/patient.model';
import { PatientService } from '../patient.service';
import { PopupService } from './popup.service';


@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit {

  message: any; 
  patient : IPatient = new Patient();


  constructor(protected patientService: PatientService,
    protected activatedRoute : ActivatedRoute,
    private popupService: PopupService) { }



  ngOnInit(): any {  
     /** 
      *   This function waits for a message from alert service, it gets 
      *   triggered when we call this from any other component 
      */  
      this.activatedRoute.data.subscribe(({patient}) =>{
        this.patient = patient;
      });
      this.popupService.getMessage().subscribe(message => {  
          this.message = message;  
      });  
  }  

}
