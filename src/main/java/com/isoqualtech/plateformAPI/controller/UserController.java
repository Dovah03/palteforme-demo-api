package com.isoqualtech.plateformAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isoqualtech.plateformAPI.service.UserService;
import com.isoqualtech.plateformAPI.Auth.ApiUser;
import com.isoqualtech.plateformAPI.model.User;
import com.isoqualtech.plateformAPI.model.Client;
import com.isoqualtech.plateformAPI.request.ChangePasswordRequest;
import com.isoqualtech.plateformAPI.request.LoginRequest;
import com.isoqualtech.plateformAPI.security.JwtErrorHandler;
import com.isoqualtech.plateformAPI.security.JwtResponse;
import com.isoqualtech.plateformAPI.security.JwtTokenUtil;



@RestController
@RequestMapping("/user")
public class UserController {
	
	public ApiUser CurrentUser;
	@Autowired
	public UserService userService;
	@Autowired
	public AuthenticationManager authenticationManager;
	@Autowired 
	public BCryptPasswordEncoder passwordEncoder;
	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	
	public UserController(UserService userService ,AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = new BCryptPasswordEncoder(10);
	}

	// @preAuth hasRole('ROLE_') hasAnyRole hasAuthority hasAnyAuthority('permission')
	
	
	@GetMapping(value = "/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> Users = userService.findAllUsers();
		return new ResponseEntity<>(Users, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/clients")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')")
	public ResponseEntity<List<Client>> getAllClients(){
		List<Client> Clients = userService.findAllClients();
		return new ResponseEntity<>(Clients, HttpStatus.OK);
	}
		
		
	@GetMapping(value = "/find/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/client/find/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
		Client client = userService.findClientById(id);
		return new ResponseEntity<>(client, HttpStatus.OK);		
	}
	
	
	@PostMapping(value = "/create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		String encodedPassword =passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		User insertedUser= userService.AddUser(user);
		return new ResponseEntity<User>(insertedUser, HttpStatus.CREATED);
	}
	@PostMapping(value = "/addd")
	@PreAuthorize("hasRole('ADMIN')")
	public void AddDevis(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		System.out.println("id" + id +" numoffre "+numOffre);
		userService.AffecterDevis(id,numOffre);
	}
	@PostMapping(value = "/addbc")
	@PreAuthorize("hasRole('ADMIN')")
	public void AddBC(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.AffecterBC(id,numOffre);
	}
	@PostMapping(value = "/addbl")
	@PreAuthorize("hasRole('ADMIN')")
	public void AddBL(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.AffecterBL(id,numOffre);
	}
	@PostMapping(value = "/addf")
	@PreAuthorize("hasRole('ADMIN')")
	public void AddFacture(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.AffecterFacture(id,numOffre);
	}
	
	@PostMapping(value = "/removed")
	@PreAuthorize("hasRole('ADMIN')")
	public void RemoveDevis(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.RetirerDevis(id,numOffre);
	}
	@PostMapping(value = "/removebc")
	@PreAuthorize("hasRole('ADMIN')")
	public void RemoveBC(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.RetirerBC(id,numOffre);
	}
	@PostMapping(value = "/removebl")
	@PreAuthorize("hasRole('ADMIN')")
	public void RemoveBL(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.RetirerBL(id,numOffre);
	}
	@PostMapping(value = "/removef")
	@PreAuthorize("hasRole('ADMIN')")
	public void RemoveFacture(@PathVariable("id") Long id,@RequestBody Long numOffre) {
		userService.RetirerFacture(id,numOffre);
	}
	
	@PutMapping(value = "/updateC/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<Client> UpdateClient(@PathVariable("id") Long id, @RequestBody Client client){
		Client UpdatedUser = userService.UpdateClient(id,client);
		
		return new ResponseEntity<>(UpdatedUser, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/update/{id}")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<User> UpdateUser(@PathVariable("id") Long id, @RequestBody User user){
		System.out.println("CHecking if an Auth is present ...");
		Authentication Auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("CHecking if Auth Object is not null...");
		if(Auth != null) {
		System.out.println("CHecking if CurrentUser exist in the Auth context...");
		ApiUser currentUser = (ApiUser) Auth.getPrincipal();
		if(currentUser==null) {
		throw new JwtErrorHandler();
		}
		System.out.println("CHecking if CurrentUser is allowed to proceed...");
		System.out.println(currentUser.getRole());
		if(currentUser.getId() == id || currentUser.getRole().equals("ROLE_ADMIN")) {
		System.out.println("All Checks passed Updating user...");
		User UpdatedUser = userService.UpdateUser(id,user);
		return new ResponseEntity<User>(UpdatedUser, HttpStatus.OK);
		}
		System.out.println("CurrentUser is not allowed to proceed... is not admin and Ids dont match");

		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
		System.out.println("Auth Context doesnt exist... User not Authententicated...");
		
		return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value = "/deactivate/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> DeactivateUser(@PathVariable("id") Long id, @RequestBody User user){
		User UpdatedUser = userService.DeactivateUser(id,user);
		return new ResponseEntity<User>(UpdatedUser, HttpStatus.OK);
	}
	
	@PutMapping(value = "/activate/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> ActivateUser(@PathVariable("id") Long id, @RequestBody User user){
		User UpdatedUser = userService.ActivateUser(id,user);
		return new ResponseEntity<User>(UpdatedUser, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
		userService.DeleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest authData) {
		Authentication session = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						authData.getUsername(),
						authData.getPassword())
			
				);
		SecurityContextHolder.getContext().setAuthentication(session);
		// generation du JWT depuis la session d'authentification
		String jwt = jwtTokenUtil.generateJwtToken(session);
		
		ApiUser userDetails = (ApiUser) session.getPrincipal();	
		CurrentUser = userDetails;
		return ResponseEntity.ok(new JwtResponse(jwt,userDetails));
	}
	@GetMapping(value = "/current")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<ApiUser> currentUser() {
		//String IDuser = SecurityContextHolder.getContext().getAuthentication().getName()
		System.out.println("retrieving curent user...");
		Authentication Auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(Auth);
		if(Auth != null) {
		ApiUser currentUser = (ApiUser) Auth.getPrincipal();
		if(currentUser==null) {
		throw new JwtErrorHandler();
		}
		return ResponseEntity.ok(currentUser);
		}
		return null;
	}
	@PutMapping(value = "/changepsw")
	@PreAuthorize("hasRole('ADMIN')" + "|| hasRole('MODERATOR')" + "|| hasRole('USER')")
	public ResponseEntity<User> changeUserPassword(@Validated @RequestBody ChangePasswordRequest data) {
		//String IDuser = SecurityContextHolder.getContext().getAuthentication().getName()
		System.out.println("retrieving curent user... and request data");
		System.out.println(data.getCurrentPassword() + " " + data.getNewPassword());

		Authentication Auth = SecurityContextHolder.getContext().getAuthentication();
		if(Auth != null) {
			System.out.println("Auth exist retreiving current user data");
			ApiUser currentApiUser = (ApiUser) Auth.getPrincipal();
			System.out.println(currentApiUser);
			Long currentUserId = currentApiUser.getId();
			User CurrentUser = userService.findUserById(currentUserId);
			String currentHash = CurrentUser.getPassword();
			//System.out.println(currentUserId);
			//System.out.println(CurrentUser);
			//System.out.println(currentHash);
			if(passwordEncoder.matches(data.getCurrentPassword(), currentHash)) {
				String encodedNewPassword =passwordEncoder.encode(data.getNewPassword());
				CurrentUser.setPassword(encodedNewPassword);
				User updatedUser = userService.UpdateUser(currentUserId, CurrentUser);
				//System.out.println(updatedUser);
				return ResponseEntity.ok(updatedUser);
		}
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
