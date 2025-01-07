import { Component, inject, OnInit } from '@angular/core';
import {RSVPService} from './rsvp.service';
import {Observable} from 'rxjs';
import {RSVP} from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  rsvpSvc = inject(RSVPService)

  rsvp$!: Observable<RSVP[]>

  ngOnInit(): void {
    this.rsvp$ = this.rsvpSvc.getRSVPS()
  }
}
