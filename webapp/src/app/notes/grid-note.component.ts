import { HttpResponse } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ColDef, GridApi, GridReadyEvent } from 'ag-grid-community';
import { filter, map } from 'rxjs/operators';
import { INote, Note } from '../model/note.model';
import { EditRouterLinkRendererComponent } from '../shared/edit-link-cell-renderer.component';
import { NoteService } from './note.service';
import { NoteDeleteRouterLinkRendererComponent } from '../shared/note-delete-link-cell-renderer.component';

@Component({
  selector: 'app-grid-note',
  templateUrl: './grid-note.component.html',
  styleUrls: ['./grid-note.component.css']
})
export class GridNoteComponent implements OnInit {

  notes: Array<INote> =[];
  private gridApi!: GridApi;

  constructor(protected noteService: NoteService,
    protected activatedRoute : ActivatedRoute) { 
      
    }

  ngOnInit(): void {
    this.loadAllByPatientId(+this.activatedRoute.snapshot.paramMap.get('patId'));
  }
  

  columnDefs: ColDef[] = [
    { field: 'id',minWidth: 250 },
    { field: 'patId',maxWidth: 130 },
    { field: 'patient',maxWidth: 130 },
    { field: 'note', minWidth: 700 },
    {
      field: 'Edit', maxWidth: 150,
      cellRenderer: EditRouterLinkRendererComponent,
      cellRendererParams: {
        inRouterLink: 'update-note'
      }
    },
    {
      field: 'Delete', maxWidth: 150,
      cellRendererFramework: NoteDeleteRouterLinkRendererComponent
    }
];

loadAllByPatientId(patId: number){
  this.noteService.getNotesByPatientId(patId).pipe(
    filter((res: HttpResponse<INote[]>) => res.ok),
    map((res: HttpResponse<INote[]>) => res.body)
  ).subscribe(res => this.notes = res);

}

refreshCell(id:String){

  this.noteService.delete(id).subscribe(async res => {
    await this.loadAllByPatientId(1);
    
  })
  this.gridApi.refreshCells({force : true});
}

onGridReady(params: GridReadyEvent) {
  this.gridApi = params.api;

  // placing in 13 rows, so there are exactly enough rows to fill the grid, makes
  // the row animation look nice when you see all the rows
  
  params.api.setRowData(this.notes);
}

previousState(){
  window.history.back();
}

}
