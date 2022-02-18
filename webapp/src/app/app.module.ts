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
import { PatientDeleteRouterLinkRendererComponent } from './shared/patient-delete-link-cell-renderer.component';
import { GridNoteComponent } from './notes/grid-note.component';
import { DispalyRouterLinkRendererComponent } from './shared/display-link-cell-renderer.component';
import { UpdateNoteComponent } from './notes/update-note/update-note.component';
import { NoteDeleteRouterLinkRendererComponent } from './shared/note-delete-link-cell-renderer.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    GridsComponent,
    UpdatePatientComponent,
    EditRouterLinkRendererComponent,
    PatientDeleteRouterLinkRendererComponent,
    NoteDeleteRouterLinkRendererComponent,
    DispalyRouterLinkRendererComponent,
    GridNoteComponent,
    UpdateNoteComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AgGridModule.withComponents([EditRouterLinkRendererComponent,PatientDeleteRouterLinkRendererComponent,NoteDeleteRouterLinkRendererComponent,DispalyRouterLinkRendererComponent]),
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
  providers: [GridsComponent,GridNoteComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
