import { ThrowStmt } from '@angular/compiler';
import { Component, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { AgRendererComponent, ICellRendererAngularComp } from 'ag-grid-angular';
import { GridsComponent } from '../patients/grids.component';

@Component({
    template: '<input type="image" value="test" src="assets/delete.svg" (click)="clicked($event)"/>'
})
export class PatientDeleteRouterLinkRendererComponent implements ICellRendererAngularComp {
    params: any;

    constructor(
        private ngZone: NgZone,
        private router: Router,
        private grid: GridsComponent) { }

    agInit(params: any): void {
        this.params = params;
    }   

    refresh(params: any): boolean {
        return false;
    }

    public clicked(cell: any): void {
        // show json data
        // open modal or popout        
        
        this.grid.refreshCell(this.params.data.id);
          }

    // This was added to make the link work correctly
    navigate(link: any) {
        this.ngZone.run(() => {
            this.router.navigate([link, this.params.value]);
        });
    }
}