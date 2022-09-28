import { Injectable } from '@angular/core';
import { Listing } from '../models/listing';
import { FileHandle } from 'src/app/models/file-handle.model';
import { DomSanitizer } from '@angular/platform-browser';


@Injectable({
  providedIn: 'root'
})
export class ImageProcessingService {

  // constructor(private sinitazer: DomSanitizer) { }

  // public createImages(listing: Listing){
  //   const listingImages: any[] = listing.ListingImages;
  //   const listingImagesToFileHandle: FileHandle[] =[];

  //   for(let i = 0; i < listingImages.length; i++){
  //     const imageFileData = listingImages[i];

  //     const imageBlob = this.dataURItoBlob(imageFileData.pic,imageFileData.type)

  //     const imageFile = new File([imageBlob], imageFileData.name, {type: imageFileData.type})

  //     const finalFileHandle: FileHandle ={
  //       file: imageFile,
  //       url: this.sinitazer.bypassSecurityTrustUrl(window.URL.createObjectURL(imageFile))
  //     };

  //     listingImagesToFileHandle.push(finalFileHandle)
  //   }

  //   listing.ListingImages = listingImagesToFileHandle;
  //   return listing;
  // }

  // public dataURItoBlob(pic: any, imageType: any){
  //   const byteString = window.atob(pic);
  //   const arrayBuffer = new ArrayBuffer(byteString.length);
  //   const int8Array = new Uint8Array(arrayBuffer);

  //   for(let i = 0; i < byteString.length; i++){
  //     int8Array[i] = byteString.charCodeAt(i)
  //   }

  //   const blob = new Blob([int8Array], {type: imageType});
  //   return blob;
  // }
}
