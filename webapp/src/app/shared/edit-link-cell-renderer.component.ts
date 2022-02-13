import { Component, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { AgRendererComponent } from 'ag-grid-angular';

@Component({
    template: '<a [routerLink]="[params.inRouterLink,params.data]"><img src="assets/edit.svg"></a>'
})
export class EditRouterLinkRendererComponent implements AgRendererComponent {
    params: any;

    constructor(
        private ngZone: NgZone,
        private router: Router) { }

    agInit(params: any): void {
        this.params = params;
    }   

    refresh(params: any): boolean {
        return false;
    }

    // This was added to make the link work correctly
    navigate(link: any) {
        this.ngZone.run(() => {
            this.router.navigate([link, this.params.value]);
        });
    }
}