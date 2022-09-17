package com.isoqualtech.plateformAPI.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.model.User;
import com.isoqualtech.plateformAPI.model.Client;
import com.isoqualtech.plateformAPI.repository.ClientRepository;
import com.isoqualtech.plateformAPI.repository.UserRepository;
import com.isoqualtech.plateformAPI.exeption.UserNotFoundException;

@Service
public class UserService {
	private final UserRepository UserRepo;
	private final ClientRepository ClientRepo;
	
	public UserService(UserRepository UserRepo, ClientRepository ClientRepo) {
		this.UserRepo = UserRepo;
		this.ClientRepo = ClientRepo;
	}
	
	@SuppressWarnings("deprecation")
	public User AddUser(User user) {
		user.setJoinDate(new Date().toGMTString());
		 User savedUser = UserRepo.save(user);
		 if(user.getRole().equals("ROLE_USER")) {
				Client UserM = new Client();
				System.out.println("id is"+savedUser.getId());
				System.out.println("id is"+savedUser.getEmail());
				UserM.setMysqlid(savedUser.getId());
				UserM.setEmail(savedUser.getEmail());
				UserM.setFirstName(savedUser.getFirstName());
				UserM.setLastName(savedUser.getLastName());
				UserM.setCompany(savedUser.getCompany());
				ClientRepo.save(UserM);
			}
		 return savedUser;
	}
	
	public List<User> findAllUsers(){
		return UserRepo.findAll();
		
	}
	
	public List<Client> findAllClients(){
		return ClientRepo.findAll();
	}
	
	public User findUserbyname(String username) {
		return UserRepo.findByUsername(username)
				.orElseThrow(()-> new UserNotFoundException ("User with username "+username+" was not found"));
	}
	
	public User findUserById(Long id) {
		return UserRepo.findById(id)
		.orElseThrow(()-> new UserNotFoundException ("User with Id "+id+" was not found"));
	}
	public Client findClientById(Long id) {
		return ClientRepo.findByMysqlid(id)
		.orElseThrow(()-> new UserNotFoundException ("Client with Id "+id+" was not found"));
	}
	
	public Client UpdateClient(Long id, Client client) {
		Client existingRecord = findClientById(id);
		if(client.getFirstName()!=null ) {
			existingRecord.setFirstName(client.getFirstName());
		}
		if(client.getLastName()!=null) {
			existingRecord.setLastName(client.getLastName());
		}
		if(client.getUsername()!=null) {
			existingRecord.setUsername(client.getUsername());
		}
		if(client.getCompany()!=null) {
			existingRecord.setCompany(client.getCompany());
		}
		if(client.getEmail()!=null) {
			existingRecord.setEmail(client.getEmail());
		}
		if(client.getBCID_list()!=null) {
			existingRecord.setBCID_list(client.getBCID_list());
		}
		if(client.getBLID_list()!=null) {
			existingRecord.setBLID_list(client.getBLID_list());
		}
		if(client.getDevisID_list()!=null) {
			existingRecord.setDevisID_list(client.getDevisID_list());
		}
		if(client.getFactureID_list()!=null) {
			existingRecord.setFactureID_list(client.getFactureID_list());
		}
		if(client.getMysqlid()!=null) {
			existingRecord.setMysqlid(client.getMysqlid());
		}
		return ClientRepo.save(existingRecord);
		
	}
	
	public User UpdateUser(Long id, User user) {
		User existingRecord = findUserById(id);
		Client existingRecord2 = findClientById(id);
		if(user.getFirstName()!=null ) {
			existingRecord.setFirstName(user.getFirstName());
			existingRecord2.setFirstName(user.getFirstName());
		}
		if(user.getPassword()!=null) {
			existingRecord.setPassword(user.getPassword());
		}
		if(user.getLastName()!=null) {
			existingRecord.setLastName(user.getLastName());
			existingRecord2.setLastName(user.getLastName());
		}
		if(user.getCompany()!=null) {
			existingRecord.setCompany(user.getCompany());
			existingRecord2.setCompany(user.getCompany());
		}
		if(user.getUsername()!=null) {
			existingRecord.setUsername(user.getUsername());
		}
		if(user.getEmail()!=null) {
			existingRecord.setEmail(user.getEmail());
		}
		if(user.getJoinDate()!=null) {
			existingRecord.setJoinDate(user.getJoinDate());
		}
		if(user.getLastloginDate()!=null) {
			existingRecord.setLastloginDate(user.getLastloginDate());
		}
		if(user.getRole()!=null) {
			existingRecord.setRole(user.getRole());
		}
		if(user.getProfileImageUrl()!=null) {
			existingRecord.setProfileImageUrl(user.getProfileImageUrl());
		}
		if(user.getDescription()!=null) {
			existingRecord.setDescription(user.getDescription());
		}
		ClientRepo.save(existingRecord2);
		return UserRepo.save(existingRecord);
	}
	
	public User DeactivateUser(Long id, User user) {
		User existingRecord = findUserById(id);
		if(user.getFirstName()!=null ) {
			existingRecord.setFirstName(user.getFirstName());
		}
		if(user.getPassword()!=null) {
			existingRecord.setPassword(user.getPassword());
		}
		if(user.getLastName()!=null) {
			existingRecord.setLastName(user.getLastName());
		}
		if(user.getUsername()!=null) {
			existingRecord.setUsername(user.getUsername());
		}
		if(user.getCompany()!=null) {
			existingRecord.setCompany(user.getCompany());
		}
		if(user.getEmail()!=null) {
			existingRecord.setEmail(user.getEmail());
		}
		if(user.getJoinDate()!=null) {
			existingRecord.setJoinDate(user.getJoinDate());
		}
		if(user.getLastloginDate()!=null) {
			existingRecord.setLastloginDate(user.getLastloginDate());
		}
		if(user.getRole()!=null) {
			existingRecord.setRole(user.getRole());
		}
		if(user.getProfileImageUrl()!=null) {
			existingRecord.setProfileImageUrl(user.getProfileImageUrl());
		}
		existingRecord.setActive(false);
		existingRecord.setIsntLocked(false);
		//user.setLastloginDate(new Date().toGMTString());
		return UserRepo.save(existingRecord);
	}
	
	public User ActivateUser(Long id, User user) {
		User existingRecord = findUserById(id);
		if(user.getFirstName()!=null ) {
			existingRecord.setFirstName(user.getFirstName());
		}
		if(user.getPassword()!=null) {
			existingRecord.setPassword(user.getPassword());
		}
		if(user.getLastName()!=null) {
			existingRecord.setLastName(user.getLastName());
		}
		if(user.getUsername()!=null) {
			existingRecord.setUsername(user.getUsername());
		}
		if(user.getCompany()!=null) {
			existingRecord.setCompany(user.getCompany());
		}
		if(user.getEmail()!=null) {
			existingRecord.setEmail(user.getEmail());
		}
		if(user.getJoinDate()!=null) {
			existingRecord.setJoinDate(user.getJoinDate());
		}
		if(user.getLastloginDate()!=null) {
			existingRecord.setLastloginDate(user.getLastloginDate());
		}
		if(user.getRole()!=null) {
			existingRecord.setRole(user.getRole());
		}
		if(user.getProfileImageUrl()!=null) {
			existingRecord.setProfileImageUrl(user.getProfileImageUrl());
		}
		existingRecord.setActive(true);
		existingRecord.setIsntLocked(true);
		//user.setLastloginDate(new Date().toGMTString());
		return UserRepo.save(existingRecord);
	}
	
	
	public void DeleteUser(Long id) {
		ClientRepo.deleteByMysqlid(id);
		UserRepo.deleteById(id);
	}
	public void AffecterDevis(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.addDevis(numOffre);
	}
	public void AffecterBC(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.addBC(numOffre);
	}
	public void AffecterBL(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.addBL(numOffre);
	}
	public void AffecterFacture(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.addFacture(numOffre);
	}
	public void RetirerDevis(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.RemoveDevis(numOffre);
	}
	public void RetirerBC(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.RemoveBC(numOffre);
	}
	public void RetirerBL(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.RemoveBL(numOffre);
	}
	public void RetirerFacture(Long id, Long numOffre) {
		Client user = findClientById(id);
		user.RemoveFacture(numOffre);
	}
}
