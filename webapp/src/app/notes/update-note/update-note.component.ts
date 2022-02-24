import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IError } from 'src/app/model/error.model';
import { INote, Note } from 'src/app/model/note.model';
import { IPatient, Patient } from 'src/app/model/patient.model';
import { PatientService } from 'src/app/patients/patient.service';
import { NoteService } from '../note.service';

@Component({
  selector: 'app-update-note',
  templateUrl: './update-note.component.html',
  styleUrls: ['./update-note.component.css']
})
export class UpdateNoteComponent implements OnInit {

  note : INote = new Note();
  public errors: IError[] = [];
  patient : IPatient= new Patient();

  constructor(protected noteService: NoteService,
    protected activatedRoute : ActivatedRoute,
    protected patientService: PatientService) { }

  ngOnInit(): void {
    this.note.id = this.activatedRoute.snapshot.paramMap.get('id');
    this.note.patId = +this.activatedRoute.snapshot.paramMap.get('patId');
    this.patientService.find(this.note.patId).subscribe((res) => {
      this.patient =res.body;
      this.note.patient = this.patient.family.concat(" ").concat(this.patient.given.toString());
    });
    if (this.note.id !== null){
       this.noteService.find(this.note.id).subscribe( (res) => this.note = res.body);
    }

  }

  save(){
    
    if (this.note.id !== undefined){
      this.subscribetoSaveResponse(this.noteService.updateNote(this.note));
    } else {
      this.subscribetoSaveResponse(this.noteService.createNote(this.note));

    }
  }

  previousState(){
    window.history.back();
  }

  protected subscribetoSaveResponse (result : Observable<HttpResponse<INote>>){
    result.subscribe((res : HttpResponse<INote>) =>this.onSaveSuccess(),(err:HttpErrorResponse) => {
       this.errors = err.error.errors;
      
    });
  }
  protected onSaveSuccess(){
    this.previousState();
  }

  

}
