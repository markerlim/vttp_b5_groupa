import { Component, Input, Output } from '@angular/core';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-text',
  standalone: false,
  templateUrl: './text.component.html',
  styleUrl: './text.component.css'
})
export class TextComponent {

  // Define a member and annotate it with @Input
  @Input()
  text: string = ''

  // Define a event with number as the event payload
  @Output()
  totalClicks = new Subject<number>()

  protected counter = 0

  protected clearCounter() {
    this.counter = 0
  }
  protected textClicked() {
    this.counter++
  }
  protected fireClicks(event: any) {
    // This event has happened
    console.info('>>>> event', event)
    this.totalClicks.next(this.counter)
  }

}
