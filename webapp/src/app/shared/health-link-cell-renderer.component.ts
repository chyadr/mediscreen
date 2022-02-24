import { ThrowStmt } from '@angular/compiler';
import { Component, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { AgRendererComponent, ICellRendererAngularComp } from 'ag-grid-angular';
import { GridNoteComponent } from '../notes/grid-note.component';

@Component({
    template: '<a [routerLink]="[params.inRouterLink,params.data.id]"><img src="assets/health.svg"></a>'
})
export class HealthRouterLinkRendererComponent implements AgRendererComponent {
    params: any;

    constructor(
        private ngZone: NgZone,
        private router: Router) { }

    agInit(params: any): void {
        this.params = params;
    }   

    refresh(params: any): boolean {
        return true;
    }

    // This was added to make the link work correctly
    navigate(link: any) {
        this.ngZone.run(() => {
            this.router.navigate([link, this.params.value]);
        });
    }
}