package com.isoqualtech.plateformAPI.Auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isoqualtech.plateformAPI.model.User;
import com.isoqualtech.plateformAPI.repository.UserRepository;

@Repository
public class ApiAuthDaoService implements ApiAuthDao{
	
	private final UserRepository Repo;

	@Autowired
	public ApiAuthDaoService(UserRepository Repo) {
		this.Repo = Repo;
	}

	@Override
	public Optional<User> selectApiUserByUsername(String username) {
	//	return getApiUsers().stream().filter(ApiUser -> username.equals(ApiUser.getUsername())).findFirst();
		
		return getDBApiUsers(username).stream().filter(ApiUser -> username.equals(ApiUser.getUsername())).findFirst();
	}
	
	private Optional<User> getDBApiUsers(String username){
		return Repo.findByUsername(username);
		
	}

	/*private List<ApiUser> getApiUsers(){
		List<ApiUser> ApiUsers = Lists.newArrayList(
				new ApiUser
				("Demo", 
				passwordEncoder.encode("password"),
				USER.getGrantedAuthorities(),
				true,
				true,
				true,
				true));
				
		return ApiUsers;
	};*/
}
