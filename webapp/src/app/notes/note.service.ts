import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { INote } from '../model/note.model';

type EntityArrayResponseType = HttpResponse<INote[]>;
type EntityResponseType = HttpResponse<INote>;

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  public url='http://localhost:8082/note/';

  constructor(private http: HttpClient) { }
  

  getNotesByPatientId(patId: number) : Observable<EntityArrayResponseType>{
    
    return this.http.get<INote[]>(`${this.url}findAllByPatId/${patId}`,{observe: 'response'});
  }

  find(id : String) : Observable<EntityResponseType> {
    
    return this.http.get<INote>(`${this.url}${id}`,{observe: 'response'});
  }

  delete(id : String) : Observable<EntityResponseType>{    

     return this.http.delete<INote>(`${this.url}${id}`, {observe: 'response'});
  }

  createNote(note: INote) : Observable<EntityResponseType>{
    
    return this.http.post<INote>(this.url+"createPatHistory",note, {observe: 'response'});
  }

  updateNote(note: INote) : Observable<EntityResponseType>{
    
    return this.http.put<INote>(this.url+"updatePatHistory",note, {observe: 'response'});

  }

      


}
