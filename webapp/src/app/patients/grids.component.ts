import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, Injector, OnInit } from '@angular/core';
import { ColDef, GridApi, GridReadyEvent } from 'ag-grid-community';
import { IPatient, Patient } from '../model/patient.model';
import { PatientService } from './patient.service';
import {filter,map} from 'rxjs/operators';
import { PartialObserver } from 'rxjs';
import { EditRouterLinkRendererComponent } from '../shared/edit-link-cell-renderer.component';
import { Router } from '@angular/router';
import { DeleteRouterLinkRendererComponent } from '../shared/delete-link-cell-renderer.component';

@Component({
  selector: 'app-grids',
  templateUrl: './grids.component.html',
  styleUrls: ['./grids.component.css']
})
export class GridsComponent implements OnInit {
  patients: Array<IPatient> =[];
  private gridApi!: GridApi;

  constructor(protected patientService: PatientService) { 
      
    }

  ngOnInit(): void {
    this.loadAll();
  }
  

  columnDefs: ColDef[] = [
    { field: 'id',maxWidth: 80 },
    { field: 'family',maxWidth: 200 },
    { field: 'given',maxWidth: 200 },
    { field: 'dob', minWidth: 300 },
    { field: 'sex',maxWidth: 80 },
    { field: 'address' },
    { field: 'phoneNumber',maxWidth: 150},
    {
      field: 'Edit', maxWidth: 150,
      cellRenderer: EditRouterLinkRendererComponent,
      cellRendererParams: {
        inRouterLink: 'update-patient'
      }
    },
    {
      field: 'Delete', maxWidth: 150,
      cellRendererFramework: DeleteRouterLinkRendererComponent,
      cellRendererParams: {
        inRouterLink:"confirm-delete"
      }
    }
];

loadAll(){
  this.patientService.getPatients().pipe(
    filter((res: HttpResponse<IPatient[]>) => res.ok),
    map((res: HttpResponse<IPatient[]>) => res.body)
  ).subscribe(res => this.patients = res);

}

refreshCell(id:number){

  this.patientService.delete(id).subscribe(async res => {
    await this.loadAll();
    
  })
  this.gridApi.refreshCells({force : true});
}

onGridReady(params: GridReadyEvent) {
  this.gridApi = params.api;

  // placing in 13 rows, so there are exactly enough rows to fill the grid, makes
  // the row animation look nice when you see all the rows
  
  params.api.setRowData(this.patients);
}




}
