package com.RealEstate_BackEnd.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.RealEstate_BackEnd.model.Client;
import com.RealEstate_BackEnd.model.Courtier;
import com.RealEstate_BackEnd.model.User;
import com.RealEstate_BackEnd.repository.ClientRepository;
import com.RealEstate_BackEnd.repository.CourtierRepository;
import com.RealEstate_BackEnd.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	
	  @Autowired
	  private UserRepository userRepository;
	  
	  @Autowired
	  private CourtierRepository courtierRepository;
	
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	  public List<Courtier> getAllClients() {
	    return courtierRepository.findAll();
	  }
	
	
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users/{id}")
	  public ResponseEntity<Courtier> getClientsById(@PathVariable(value = "id") Long id)
	      throws ResourceNotFoundException {
		Courtier user =
	    		courtierRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
	    return ResponseEntity.ok().body(user);
	  }
	
	
					@PostMapping("/users")
					  public Courtier createClient( @RequestBody Courtier courtier) {
					    return courtierRepository.save(courtier);
					  }
	
	
//	@PreAuthorize("hasRole('ADMIN')")
	 @PutMapping("/users/{id}")
	  public ResponseEntity<Courtier> updateClient(
	      @PathVariable(value = "id") Long id, @Valid @RequestBody Courtier ClientDetails)
	      throws ResourceNotFoundException {

		 Courtier user =
	    		courtierRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
	    
       user.setName(ClientDetails.getName());
       user.setPassword(ClientDetails.getPassword());
       user.setEmail(ClientDetails.getEmail());
       user.setTelephone(ClientDetails.getTelephone());
       user.setUsername(ClientDetails.getUsername());
	    
	   
	    final Courtier updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	  }
	
//	 @PreAuthorize("hasRole('ADMIN')")
	 @DeleteMapping("/users/{id}")
	  public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long id) throws Exception {
		 Courtier user =
				 courtierRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Courtier not found on :: " + id));

		 courtierRepository.delete(user);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	
	 

}
