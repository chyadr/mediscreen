import { Injectable, NgModule } from '@angular/core';
import { Routes, RouterModule, Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { GridsComponent } from './patients/grids.component';
import { UpdatePatientComponent } from './patients/update-patient/update-patient.component';
import { IPatient, Patient } from './model/patient.model';
import { PatientService } from './patients/patient.service';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class PatientResolve implements Resolve<IPatient | null> {
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



const appRoutes: Routes = [
  { path: 'patients', component:  GridsComponent},
  { path: 'patients/update-patient', component:  UpdatePatientComponent,
  resolve:  {
    patient: PatientResolve
          }},  
  { path: 'patient', component:  UpdatePatientComponent,
  resolve:  {
    patient: PatientResolve
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
