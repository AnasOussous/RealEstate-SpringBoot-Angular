import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Listing } from '../models/listing';

@Injectable({
  providedIn: 'root'
})
export class ListingService {

  private baseURL = 'http://localhost:8080/api/listings';
  constructor(private httpClient: HttpClient) { }

getListingList():Observable<Listing[]>{
  return this.httpClient.get<Listing[]>(`${this.baseURL}`);
}

// createListing(listing:FormData): Observable<Object>{
//   return this.httpClient.post(`${this.baseURL}`, listing);
// }

createListing(listing:Listing): Observable<Object>{
  return this.httpClient.post(`${this.baseURL}`, listing);
}

getListingById(id: number): Observable<Listing>{
  return this.httpClient.get<Listing>(`${this.baseURL}/${id}`);
}

updateListing(id:number, listing: Listing): Observable<Object>{
  return this.httpClient.put(`${this.baseURL}/${id}`,listing);
}

deleteListing(id: number):Observable<Object>{
  return this.httpClient.delete(`${this.baseURL}/${id}`);

}
}
