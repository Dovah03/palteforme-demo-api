package com.isoqualtech.plateformAPI.Auth;

import java.util.Optional;

import com.isoqualtech.plateformAPI.model.User;

public interface ApiAuthDao {
	
	public Optional<User> selectApiUserByUsername(String username);

}
