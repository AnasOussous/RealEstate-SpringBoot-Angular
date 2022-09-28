import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {


  private baseURL = 'http://localhost:8080/api/categories';
  constructor(private httpClient: HttpClient) { }

getCategoryList():Observable<Category[]>{
  return this.httpClient.get<Category[]>(`${this.baseURL}`);
}

createCategory(category:Category): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, category);
}

getCategoryById(id: number): Observable<Category>{
  return this.httpClient.get<Category>(`${this.baseURL}/${id}`);
}

updateCategory(id:number, category: Category): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`,category);
}

deleteCategory(id: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${id}`);

}

}
