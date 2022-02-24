import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  navLinks: any[];

  constructor() {
    this.navLinks = [
      {
        label: 'Patients',
        link: 'patients',
        index: 0
      }
    ];

  }

  ngOnInit() {
  }

}