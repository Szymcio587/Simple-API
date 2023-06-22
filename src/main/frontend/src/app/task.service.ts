import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  tasks: any;

  constructor(private http: HttpClient) { }

  GetAllData(): Observable<any[]> {
    return this.http.get<any[]>("http://localhost:8080/tasks");
  }

  DeleteEntity(id: number): Observable<Object> {
    const url = `http://localhost:8080/delete/${id}`;
    return this.http.delete(url,  { responseType: 'json' });
  }

  GetRequestsNumber(): Observable<number> {
    return this.http.get<number>("http://localhost:8080/requests");
  }
}
