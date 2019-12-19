import { Injectable } from '@angular/core';
import { SERVER_API_URL } from '../app.constants';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Alairas } from './alairas.model';
import { Observable } from 'rxjs';

@Injectable()
export class AlairasService {
  protected resourceUrl = SERVER_API_URL + '/alairasok';

  constructor(protected http: HttpClient) {
  }

  getAll(): Observable<HttpResponse<Alairas[]>> {
    console.log('enaploAktasAvailableForHatosag()');
    return this.http.get<Alairas[]>(`${this.resourceUrl}`, { observe: 'response' });
  }

  getOneById(id: number): Observable<HttpResponse<Alairas>> {
    console.log('enaploAktasAvailableForHatosag()');
    return this.http.get<Alairas>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
