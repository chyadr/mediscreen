import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { IPatient, Patient } from '../model/patient.model';
import { BehaviorSubject, Observable } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';

type EntityArrayResponseType = HttpResponse<IPatient[]>;
type EntityResponseType = HttpResponse<IPatient>;


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  public url='http://localhost:8081/patient/';


  constructor(private http: HttpClient) { }


  getPatients() : Observable<EntityArrayResponseType>{
    
    return this.http.get<IPatient[]>(this.url,{observe: 'response'});
  }

  find(id : number) : Observable<EntityResponseType> {
    
    return this.http.get<IPatient>(`${this.url}${id}`,{observe: 'response'});
  }

  delete(id : number) : Observable<EntityResponseType>{    

     return this.http.delete<IPatient>(`${this.url}${id}`, {observe: 'response'});
  }

  createPatient(patient: IPatient) : Observable<EntityResponseType>{
    
    return this.http.post<IPatient>(this.url+"createPatient",patient, {observe: 'response'})
    .pipe(map((res : EntityResponseType) => this.convertDateFromServer(res)));
  }

  updatePatient(patient: IPatient) : Observable<EntityResponseType>{
    
    return this.http.put<IPatient>(this.url+"updatePatient",patient, {observe: 'response'})
    .pipe(map((res : EntityResponseType) => this.convertDateFromServer(res)));

  }

      
protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
  if (res.body) {
      res.body.dob = res.body.dob != null ? moment.utc(res.body.dob) : null;
  }
  return res;
}

protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
  if (res.body) {
      res.body.forEach((patient: IPatient) => {
          patient.dob = patient.dob != null ? moment.utc(patient.dob) : null;
          
      });
  }
  return res;
}

}
