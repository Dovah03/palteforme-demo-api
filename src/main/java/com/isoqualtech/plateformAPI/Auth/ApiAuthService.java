package com.isoqualtech.plateformAPI.Auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isoqualtech.plateformAPI.model.User;
import com.isoqualtech.plateformAPI.repository.UserRepository;

@Service
public class ApiAuthService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	

	public ApiAuthService(ApiAuthDao apiAuthDao) {
	}
	public UserDetails loadUserByid(String id) throws UsernameNotFoundException {
		Long ID=Long.parseLong(id);
	System.out.println("fetching username from jwt");
		User user = repo.findById(ID)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));

		return ApiUser.build(user);
}

	@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("fetching username from jwt");
			User user = repo.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

			return ApiUser.build(user);
	}
	
	/*
	 * private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        {
        	return authorities;
        }
	}
	*/

}
