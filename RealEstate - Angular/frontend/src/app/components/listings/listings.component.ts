import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Listing } from 'src/app/models/listing';
import { CategoryService } from 'src/app/services/category.service';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.css']
})
export class ListingsComponent implements OnInit {
  listings: Listing[] = [];

  categorys: Category[] = [];

  constructor(private categoryService: CategoryService, private listingService: ListingService, private router: Router) { }

  ngOnInit(): void {
    this.getListing();
    this.getCategory();
  }

  private getListing(){
    this.listingService.getListingList().subscribe(data =>{
      this.listings = data;
    });
  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
    });
  }
}
