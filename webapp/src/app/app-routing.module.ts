import { Injectable, NgModule } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { GridsComponent } from './patients/grids.component';
import { UpdatePatientComponent } from './patients/update-patient/update-patient.component';
import { IPatient, Patient } from './model/patient.model';
import { PatientService } from './patients/patient.service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { GridNoteComponent } from './notes/grid-note.component';
import { INote, Note } from './model/note.model';
import { NoteService } from './notes/note.service';
import { UpdateNoteComponent } from './notes/update-note/update-note.component';

@Injectable({ providedIn: 'root' })
export class PatientResolve implements Resolve<IPatient | null> {
  patient : IPatient;
    constructor(private service: PatientService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<IPatient | null> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Patient>) => response.ok),
                map((pt: HttpResponse<Patient>) => pt.body)
            );
        }
        return of(new Patient());
    }
}

@Injectable({ providedIn: 'root' })
export class NoteResolve implements Resolve<INote | null> {
  note : INote;
    constructor(
      private service: NoteService) {}


 resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<INote | null> {
  const id = route.params['id'] ? route.params['id'] : null;
  if (id) {
      return this.service.find(id).pipe(
          filter((response: HttpResponse<Note>) => response.ok),
          map((pt: HttpResponse<Note>) => pt.body)
      );
  }
  return of(new Note());
}
}



const appRoutes: Routes = [
  { path: 'patients', component:  GridsComponent},
  { path: 'patients/update-patient/:id', component:  UpdatePatientComponent,
  resolve:  {
    patient: PatientResolve
          }},
          { path: 'patients/update-patient', component:  UpdatePatientComponent,
          resolve:  {
            patient: PatientResolve
                  }},
  { path: 'patient', component:  UpdatePatientComponent,
  resolve:  {
    patient: PatientResolve
  }},
  { path: 'patients/notes/:patId', component:  GridNoteComponent},
  { path: 'patients/notes/:patId/update-note', component:  UpdateNoteComponent,
  resolve:  {
    patient: NoteResolve
          }},
  { path: 'patients/notes/:patId/update-note/:id', component:  UpdateNoteComponent,
  resolve:  {
    patient: NoteResolve
          }}, 
  { path: 'note', component:  UpdatePatientComponent,
  resolve:  {
    patient: NoteResolve
  }}
  ];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRoutes)
],
exports: [
    RouterModule
]
})
export class AppRoutingModule { }
