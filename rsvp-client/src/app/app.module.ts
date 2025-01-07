import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {provideHttpClient} from '@angular/common/http';
import {RSVPService} from './rsvp.service';
import { MainComponent } from './components/main.component';
import { AddRsvpComponent } from './components/add-rsvp.component';
import {RouterModule, Routes} from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';

const appRoutes: Routes = [
  { path: '', component: MainComponent },
  { path: 'add', component: AddRsvpComponent },

]

@NgModule({
  declarations: [
    AppComponent, MainComponent, AddRsvpComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes), ReactiveFormsModule
  ],
  providers: [ provideHttpClient(), RSVPService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
