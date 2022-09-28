import { Component, OnInit } from '@angular/core';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private listingService: ListingService) { }

  ngOnInit(): void {
  }

}
