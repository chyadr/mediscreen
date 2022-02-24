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
import { HealthRouterLinkRendererComponent } from './shared/health-link-cell-renderer.component';
import { HealthComponent } from './health/health.component';
import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';


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
    UpdateNoteComponent,
    HealthRouterLinkRendererComponent,
    HealthComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AgGridModule.withComponents([EditRouterLinkRendererComponent,PatientDeleteRouterLinkRendererComponent,NoteDeleteRouterLinkRendererComponent,DispalyRouterLinkRendererComponent,HealthRouterLinkRendererComponent]),
    MatTabsModule,
    BrowserAnimationsModule,
    RouterModule,
    AppRoutingModule,
    MatInputModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatRadioModule,
    FormsModule,
    MatMomentDateModule
  ],
  providers: [GridsComponent,GridNoteComponent, { provide: MAT_MOMENT_DATE_ADAPTER_OPTIONS, useValue: { useUtc: true } }],
  bootstrap: [AppComponent]
})
export class AppModule { }
