import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Listing } from 'src/app/models/listing';
import { CategoryService } from 'src/app/services/category.service';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-updatelisting',
  templateUrl: './updatelisting.component.html',
  styleUrls: ['./updatelisting.component.css']
})
export class UpdatelistingComponent implements OnInit {
  categorys: Category[] = [];
  Id!: number;
  listing: Listing = new Listing();
  constructor(private categoryService: CategoryService,private listingService: ListingService, 
    private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.listingService.getListingById(this.Id).subscribe(data =>{
      this.listing = data;
    },error => console.log(error));
    this.getCategory();
  }

  onSubmit(){
    this.listingService.updateListing(this.Id, this.listing).subscribe(data =>{
      this.goToListingList();
    },
       error => console.log(error));
       

  }

  goToListingList(){
    this.router.navigate(['/listings']);

  }

  private getCategory(){
    this.categoryService.getCategoryList().subscribe(data =>{
      this.categorys = data;
    });
  }

}
