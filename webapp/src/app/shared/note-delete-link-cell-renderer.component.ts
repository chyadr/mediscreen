import { ThrowStmt } from '@angular/compiler';
import { Component, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { AgRendererComponent, ICellRendererAngularComp } from 'ag-grid-angular';
import { GridNoteComponent } from '../notes/grid-note.component';

@Component({
    template: '<input type="image" value="test" src="assets/delete.svg" (click)="clicked($event)"/>'
})
export class NoteDeleteRouterLinkRendererComponent implements ICellRendererAngularComp {
    params: any;

    constructor(
        private ngZone: NgZone,
        private router: Router,
        private grid: GridNoteComponent) { }

    agInit(params: any): void {
        this.params = params;
    }   

    refresh(params: any): boolean {
        return false;
    }

    public clicked(cell: any): void {
        // show json data
        // open modal or popout
        console.log(this.params);
        console.log(this.params.data.id);
        
        
        this.grid.refreshCell(this.params.data.id);
          }

    // This was added to make the link work correctly
    navigate(link: any) {
        this.ngZone.run(() => {
            this.router.navigate([link, this.params.value]);
        });
    }
}