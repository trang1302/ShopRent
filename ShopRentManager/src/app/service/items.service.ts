import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Items } from '../model/items.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'Application/json' })
}
const apiUrl = 'http://localhost:8080/getItemByOrder?keyword=';


@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  constructor(private httpClient: HttpClient) { }

  getAll(keyword: any): Observable<Items[]> {
    return this.httpClient.get<Items[]>(apiUrl + keyword).pipe(
    )
  }
}
