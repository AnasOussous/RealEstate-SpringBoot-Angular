import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { FileHandle } from 'src/app/models/file-handle.model';
import { Listing } from 'src/app/models/listing';
import { CategoryService } from 'src/app/services/category.service';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-addlisting',
  templateUrl: './addlisting.component.html',
  styleUrls: ['./addlisting.component.css']
})
export class AddlistingComponent implements OnInit {
  listing: Listing = new Listing;


  categorys: Category[] = [];
  // listing: Listing = {
  //   id: 0,
  //   name: "",
  //   description: "",
  //   price: 0,
  //   city: "",
  //   beds: 0,
  //   baths: 0,
  //   m2: 0,
  //   sellOrRent: false,
  //   categorieId: 0,
  //   // ListingImages: []
  // }
  constructor(private categoryService: CategoryService,private listingService: ListingService, 
    private router: Router, private sanitizer:DomSanitizer) { }

  ngOnInit(): void {
    this.getCategory();
  }

  saveListing(){
    //  const linstingFormData = this.prepareFormData(this.listing);

    // this.listingService.createListing(linstingFormData).subscribe(data => {
    //   console.log(data);
    //   this.goToListingList();
    
    // },
    //   error => console.log(error));
    this.listingService.createListing(this.listing).subscribe(data => {
      console.log(data);
      this.goToListingList();
    },
    error => console.log(error));
  }
  
    // prepareFormData(listing: Listing): FormData {
    //   const formData = new FormData();

    //   formData.append(
    //     'listing',
    //     new Blob([JSON.stringify(listing)], {type: 'application/json'})
    //   );

    //   for(var i = 0; i < listing.ListingImages.length; i++){
    //     formData.append(
    //         'imageFile',
    //         listing.ListingImages[i].file,
    //         listing.ListingImages[i].file.name
    //       );
    //   }
    //   return formData;
    // }

    goToListingList(){
      this.router.navigate(['/listings']);
      
    }
  
    onSubmit(){
      console.log(this.listing);
      this.saveListing()
      this.goToListingList();
      window.location.reload;
  
    }

    // onFileSelected(event: any){
    //   if(event.target.files){
    //     const file = event.target.files[0];

    //     const fileHandle : FileHandle = {
    //       file: file,
    //       url: this.sanitizer.bypassSecurityTrustUrl(
    //         window.URL.createObjectURL(file)
    //       )
    //     }

    //     this.listing.ListingImages.push(fileHandle);

    //   }
    // }

    // removeImages(i:number) {
    //   this.listing.ListingImages.splice(i,1)
    // }

    // fileDropped(fileHandle: FileHandle){
    //   this.listing.ListingImages.push(fileHandle);
    // }

    private getCategory(){
      this.categoryService.getCategoryList().subscribe(data =>{
        this.categorys = data;
      });
    }

}
