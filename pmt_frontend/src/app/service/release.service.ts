import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Release } from '../classes/release';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReleaseService {

  private baserURL ="http://localhost:8080/api/v1/release"
  constructor(private httpClient:HttpClient) { }

  //------------------ get Release API ------------------
  getRelease():Observable<Release[]>{
    return this.httpClient.get<Release[]>(`${this.baserURL}`);
  }
  
  //------------------ get Release BY ID API ------------------
  
  getReleaseById( id: number) : Observable<Release>{
    return this.httpClient.get<Release>(`${this.baserURL}/${id}`) ;
  }
}
