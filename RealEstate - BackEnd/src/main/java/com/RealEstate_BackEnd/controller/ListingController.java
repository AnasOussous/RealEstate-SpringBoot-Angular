package com.RealEstate_BackEnd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import com.RealEstate_BackEnd.model.Categorie;
import com.RealEstate_BackEnd.model.Listing;
import com.RealEstate_BackEnd.repository.ListingsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class ListingController {

	@Autowired
	private ListingsRepository listingsRepository;

//	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	@GetMapping("/listings")
	public List<Listing> getAllProduits() {
		return listingsRepository.findAll();
	}

//	@PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
	@GetMapping("/listings/{id}")
	public ResponseEntity<Listing> getListingById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found on :: " + id));
		return ResponseEntity.ok().body(listing);
	}
	

	@PostMapping("/listings")
	  public Listing createListing(@Valid @RequestBody Listing listing) {
	     return listingsRepository.save(listing);
	    }

//	@PreAuthorize("hasRole('ADMIN')")
//	@PostMapping(value = {"/listings"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//	public Listing createListing(@RequestPart("listing") Listing listing,@RequestPart("imageFile")MultipartFile[] file) {
//		
//		try {
//			Set<ImageModel> images = uploadImage(file);
//			listing.setListingImages(images);
//			return listingsRepository.save(listing);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}
	
//	public Set<ImageModel> uploadImage(MultipartFile[] multipartfiles) throws IOException {
//		Set<ImageModel> imageModels = new HashSet<>();
//		
//		for(MultipartFile file: multipartfiles) {
//			ImageModel imageModel = new ImageModel(
//					file.getOriginalFilename(),
//					file.getContentType(),
//					file.getBytes()
//			);
//			imageModels.add(imageModel);
//		}
//		return imageModels;
//	}

//	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/listings/{id}")
	public ResponseEntity<Listing> updateListing(@PathVariable(value = "id") Long id,
			@RequestBody Listing listingDetails) throws ResourceNotFoundException {

		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found on :: " + id));

		listing.setName(listingDetails.getName());
		listing.setDescription(listingDetails.getDescription());
		listing.setPrice(listingDetails.getPrice());
		listing.setBaths(listingDetails.getBaths());
		listing.setBeds(listingDetails.getBeds());
		listing.setCity(listingDetails.getCity());
		listing.setM2(listingDetails.getM2());
//		listing.setSellOrRent(listingDetails.getSellOrRent());
//		listing.setCategorieId(listingDetails.getCategorieId());

		final Listing updatedListing = listingsRepository.save(listing);
		return ResponseEntity.ok(updatedListing);
	}

//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/listings/{id}") // done !!!!!!!!
	public Map<String, Boolean> deleteListing(@PathVariable(value = "id") Long id) throws Exception {
		Listing listing = listingsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Listing not found on :: " + id));

		listingsRepository.delete(listing);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
