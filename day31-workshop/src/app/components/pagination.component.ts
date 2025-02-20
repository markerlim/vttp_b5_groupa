import { Component, Input, Output } from '@angular/core';
import { Subject } from 'rxjs';
import { PageEvent } from '../models';

@Component({
  selector: 'app-pagination',
  standalone: false,
  templateUrl: './pagination.component.html',
  styleUrl: './pagination.component.css'
})
export class PaginationComponent {

  @Output()
  onNavigate = new Subject<PageEvent>()

  private step = 1

  protected page(delta: number) {
    //console.info(`delta: ${delta}`)
    const pageEvent: PageEvent = {
      delta, // delta: delta
      step: this.step
    }
    this.onNavigate.next(pageEvent)
  }

  protected updateStep(event: any) {
    this.step = parseInt(event.target.value)
  }

}
