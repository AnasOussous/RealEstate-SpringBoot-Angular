import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Listing } from 'src/app/models/listing';
import { ImageProcessingService } from 'src/app/services/image-processing.service';
import { ListingService } from 'src/app/services/listing.service';

@Component({
  selector: 'app-listingdetails',
  templateUrl: './listingdetails.component.html',
  styleUrls: ['./listingdetails.component.css']
})
export class ListingdetailsComponent implements OnInit {
  @Input() trueValue = true;
  @Input() falseValue = false;

  Id!: number;
  listing: Listing = new Listing();
  constructor(private listingService: ListingService, 
    private route: ActivatedRoute, private router: Router, private imageProccessingService: ImageProcessingService) { }
    

  ngOnInit(): void {
    this.Id = this.route.snapshot.params['id'];
    this.listingService.getListingById(this.Id).subscribe(data =>{
      this.listing = data;
    },error => console.log(error));
  }



}
