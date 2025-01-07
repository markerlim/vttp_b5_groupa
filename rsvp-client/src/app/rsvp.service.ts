import {Injectable, inject} from "@angular/core";
import {RSVP} from "./models";
import {HttpClient} from "@angular/common/http";
import { catchError, firstValueFrom, Observable, of} from "rxjs";

@Injectable()
export class RSVPService {

  private http = inject(HttpClient)

  createRSVP(rsvp: RSVP): Promise<any> {
    return firstValueFrom<any>(
      this.http.post<any>('/api/rsvp', rsvp)
    )
  }

  getRSVPS(): Observable<RSVP[]> {
    return this.http.get<RSVP[]>('/api/rsvps')
      .pipe(
        catchError(() => this.getMockRSVPS())
      )
  }

  getMockRSVPS(): Observable<RSVP[]> {
    return of<RSVP[]>([
      {
        email: 'ERROR',
        phone: 'ERROR',
        confirmDate: 'ERROR',
        comments: `
          This error message will go away when the REST API is behaving correctly
        `,
      }
    ])
  }
}
