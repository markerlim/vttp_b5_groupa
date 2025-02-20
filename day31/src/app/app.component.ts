import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'my first Angular application';

  texts: string[] = [ ]

  allClicks = 0

  whenNewText(newText: string) {
    this.texts.push(newText)
  }

  // Event handler
  whenTotalClicks(idx: number, clicks: number) {
    console.info('>>>> got totalClicks event', clicks)
    console.info(`Got clicks ${clicks} from ${idx}`)
    this.allClicks += clicks
  }

}
