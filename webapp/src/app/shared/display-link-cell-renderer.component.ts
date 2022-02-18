import { Component, Input, NgZone } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AgRendererComponent } from 'ag-grid-angular';

@Component({
    template: '<a [routerLink]="[params.inRouterLink,this.params.data.id]"><img src="assets/note.svg"></a>'
})
export class DispalyRouterLinkRendererComponent implements AgRendererComponent {
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