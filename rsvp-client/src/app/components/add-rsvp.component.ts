import { Component, inject, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {RSVPService} from '../rsvp.service';

@Component({
  selector: 'app-add-rsvp',
  standalone: false,

  templateUrl: './add-rsvp.component.html',
  styleUrl: './add-rsvp.component.css'
})
export class AddRsvpComponent implements OnInit {

  private fb = inject(FormBuilder)
  private router = inject(Router)
  private rsvpSvc = inject(RSVPService)

  protected rsvpForm!: FormGroup

  ngOnInit(): void {
    this.rsvpForm = this.createForm()
  }

  processForm() {
    const rsvp = this.rsvpForm.value
    console.info('>>> form: ', rsvp)
    this.rsvpSvc.createRSVP(rsvp)
      .then(() => {
        this.rsvpForm = this.createForm()
        this.router.navigate(['/'])
      })
      .catch(err => alert(`ERROR:\n${JSON.stringify(err)}`))
  }

  private createForm(): FormGroup {
    return this.fb.group({
      email: this.fb.control('', [ Validators.email ]),
      phone: this.fb.control('', [ Validators.required ]),
      confirmDate: this.fb.control('', [ Validators.required ]),
      comments: this.fb.control('')
    })
  }

}
