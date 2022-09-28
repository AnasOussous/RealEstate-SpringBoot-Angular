package com.RealEstate_BackEnd.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.RealEstate_BackEnd.model.Admin;
import com.RealEstate_BackEnd.model.Client;
import com.RealEstate_BackEnd.model.Courtier;
import com.RealEstate_BackEnd.model.ERole;
import com.RealEstate_BackEnd.model.Role;
import com.RealEstate_BackEnd.payload.request.LoginRequest;
import com.RealEstate_BackEnd.payload.request.SignupRequest;
import com.RealEstate_BackEnd.payload.response.JwtResponse;
import com.RealEstate_BackEnd.payload.response.MessageResponse;
import com.RealEstate_BackEnd.repository.RoleRepository;
import com.RealEstate_BackEnd.repository.UserRepository;
import com.RealEstate_BackEnd.security.jwt.JwtUtils;
import com.RealEstate_BackEnd.security.service.UserDetailsImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "*", maxAge = 3600)

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;

	  @Autowired
	  JwtUtils jwtUtils;
	  
	  
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	  
	  
	  @PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }
         
	   
						   
	    Admin admin = new Admin(signUpRequest.getName(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getUsername(),
	    		encoder.encode(signUpRequest.getPassword()));
	    
	    
	    Client client = new Client(signUpRequest.getName(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getUsername(),
	    		encoder.encode(signUpRequest.getPassword()));
	    
	    Courtier courtier = new Courtier(signUpRequest.getName(),
	    		signUpRequest.getTelephone(),
	    		signUpRequest.getEmail(),
	    		signUpRequest.getUsername(),
	    		encoder.encode(signUpRequest.getPassword()));

	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	    	 Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
	    	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	    	      roles.add(clientRole);
	    	      client.setRoles(roles);
	  		    userRepository.save(client);
	    	
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);
	          
	          admin.setRoles(roles);
	  	    userRepository.save(admin);
	         break;
	        case "client":
	          Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(clientRole);
	          client.setRoles(roles);
			    userRepository.save(client);
			    break;
	        case "courtier":
	          Role courtierRole = roleRepository.findByName(ERole.ROLE_COURTIER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(courtierRole);
	          courtier.setRoles(roles);
			    userRepository.save(courtier);
	  	    
	        }
	      });
	    }

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }
	  
//	  @GetMapping("/logout")
//      public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
//          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//          if (auth != null) {
//              new SecurityContextLogoutHandler().logout(request, response, auth);
//          }
//            
//          return "redirect:/login?logout";
//      }
	  

}
