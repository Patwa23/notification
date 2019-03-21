import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  getEmployees(){
   // return this.http.get('/server/prod/api/books');
   // http://localhost:4200/server/prod/api/books
   return this.http.get('http://localhost:8081/prod/api/books');

  }
}
