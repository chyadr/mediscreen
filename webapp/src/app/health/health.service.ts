import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IHealth, Health } from '../model/health.model';


type EntityResponseType = HttpResponse<IHealth>;


@Injectable({
  providedIn: 'root'
})
export class HealthService {

  public url='http://localhost:8080/assessment/';


  constructor(private http: HttpClient) { }



  find(id : number) : Observable<EntityResponseType> {
    
    return this.http.get<IHealth>(`${this.url}${id}`,{observe: 'response'});
  }
}
