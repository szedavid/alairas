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

  // getAll(page: number): Observable<HttpResponse<Alairas[]>> {
  getAll(page: number) {
    // return this.http.get<Alairas[]>(`${this.resourceUrl}?page=${page}`, { observe: 'response' });
    return this.http.get(this.resourceUrl + '?page=' + page);
  }

  getOneById(id: number) {
    return this.http.get<Alairas>(this.resourceUrl + '/' + id);
  }

  deleteById(id: number) {
    return this.http.delete(this.resourceUrl + '/' + id);
  }
}
