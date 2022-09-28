import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Listing } from 'src/app/models/listing';
import { AuthService } from 'src/app/services/auth.service';
import { CategoryService } from 'src/app/services/category.service';
import { ListingService } from 'src/app/services/listing.service';
import { StorageService } from 'src/app/services/storage.service';
import { EventBusService } from 'src/app/_shared/event-bus.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  Id!: number;
  listings: Listing[] = [];
  categorys: Category[] = [];
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showCourtierBoard = false;
  showClientBoard = false;
  username?: string;

  category = '';
  nom = '';

  constructor(private categoryService: CategoryService,private listingService: ListingService, private router: Router,private storageService: StorageService,
    private authService: AuthService,
    private eventBusService: EventBusService) { }

  ngOnInit(): void {
    this.getListing();

    this.getCategory();

    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showCourtierBoard = this.roles.includes('ROLE_COURTIER');
      this.showClientBoard = this.roles.includes('ROLE_CLIENT');

      this.username = user.username;
    }
  }

  private getListing(){
    this.listingService.getListingList().subscribe(data =>{
      this.listings = data;
    });
  }

  deleteListing (id: number){
    this.listingService.deleteListing(id).subscribe(data =>{
   console.log(data);
      this.getListing();
    })
  }

  updateListing(id: number){
    this.router.navigate(['listings', id]);
  }

  listingDetails(id:number){
    this.router.navigate(['listingdetails', id]);
  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
    });
  }

}
