import { Component, inject, OnInit } from '@angular/core';
import {Observable} from 'rxjs';

import {RSVPService} from '../rsvp.service';
import {RSVP} from '../models';

@Component({
  selector: 'app-main',
  standalone: false,

  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit {

  rsvpSvc = inject(RSVPService)

  rsvp$!: Observable<RSVP[]>

  ngOnInit(): void {
    this.rsvp$ = this.rsvpSvc.getRSVPS()
  }

}
