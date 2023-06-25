import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tree } from './tree';

@Injectable({
  providedIn: 'root'
})
export class NavigationService {

  private baseUrl = "http://localhost:8080/api/v1/";
  constructor(private httpClient: HttpClient) { }

  getTree(): Observable<Tree[]> {
    return this.httpClient.get<Tree[]>(`${this.baseUrl}Tree`)
  }
}
