import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './core/header/header.component';
import { FooterComponent } from './core/footer/footer.component';
import { GridsComponent } from './patients/grids.component';
import { MatTabsModule } from '@angular/material/tabs';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import { AgGridModule } from 'ag-grid-angular';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { UpdatePatientComponent } from './patients/update-patient/update-patient.component';
import {MatInputModule} from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatRadioModule } from '@angular/material/radio';
import { FormsModule }   from '@angular/forms';
import { EditRouterLinkRendererComponent } from './shared/edit-link-cell-renderer.component';
import { DeleteRouterLinkRendererComponent } from './shared/delete-link-cell-renderer.component';
import { PopupComponent } from './patients/popup/popup.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    GridsComponent,
    UpdatePatientComponent,
    EditRouterLinkRendererComponent,
    DeleteRouterLinkRendererComponent,
    PopupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AgGridModule.withComponents([EditRouterLinkRendererComponent,DeleteRouterLinkRendererComponent]),
    MatTabsModule,
    BrowserAnimationsModule,
    RouterModule,
    AppRoutingModule,
    MatInputModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatRadioModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
