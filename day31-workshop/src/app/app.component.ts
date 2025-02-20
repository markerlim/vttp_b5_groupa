import { Component } from '@angular/core';
import { PageEvent } from './models';

const NUM_IMAGES = 31

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {

  image = "/numbers/number0.jpg"
  currIndex = 0

  whenNavigate(pageEvent: PageEvent) {

    this.currIndex += pageEvent.delta * pageEvent.step

    if (this.currIndex < 0)
      this.currIndex = NUM_IMAGES + this.currIndex;
    else (this.currIndex >= NUM_IMAGES)
      this.currIndex %= NUM_IMAGES

    this.image = `/numbers/number${this.currIndex}.jpg`
  }
}
