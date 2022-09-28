package com.RealEstate_BackEnd.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.RealEstate_BackEnd.model.Categorie;
import com.RealEstate_BackEnd.repository.CategorieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RequestMapping("/api")
public class CategorieController {
	
			  @Autowired
			  private CategorieRepository categorieRepository;
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/categories")
			  public List<Categorie> getAllCategories() {
			    return categorieRepository.findAll();
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
			  @GetMapping("/categories/{id}")
			  public ResponseEntity<Categorie> getCategoriesById(@PathVariable(value = "id") Long id)
			      throws ResourceNotFoundException {
				  Categorie categorie =
						  categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));
			    return ResponseEntity.ok().body(categorie);
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PostMapping("/categories")
			  public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
			    return categorieRepository.save(categorie);
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @PutMapping("/categories/{id}")
			  public ResponseEntity<Categorie> updateCategorie(
			      @PathVariable(value = "id") Long id, @Valid @RequestBody Categorie categorieDetails)
			      throws ResourceNotFoundException {

				  Categorie categorie =
			    		categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));
				  
				  categorie.setNom(categorieDetails.getNom());
		       
			    
			   
			    final Categorie updatedCategorie = categorieRepository.save(categorie);
			    return ResponseEntity.ok(updatedCategorie);
			  }
			  
//			  @PreAuthorize("hasRole('ADMIN')")
			  @DeleteMapping("/categories/{id}")
			  public Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") Long id) throws Exception {
				  Categorie categorie =
						  categorieRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Categorie not found on :: " + id));

				categorieRepository.delete(categorie);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
			  }
			  

}
