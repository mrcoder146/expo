import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImpedimentsService {
  updateImpediments(id: number, updatedImpediments: { title: string; description: string; priority: string; status: string; sprintId: string; }) {
    throw new Error('Method not implemented.');
  }
  private apiUrl = 'http://localhost:8080/api/v1/impediment';

  constructor(private http: HttpClient) { }

  getImpediments(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  createImpediment(impediment: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, impediment);
  }
}
