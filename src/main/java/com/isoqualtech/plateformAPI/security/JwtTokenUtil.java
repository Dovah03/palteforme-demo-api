package com.isoqualtech.plateformAPI.security;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.isoqualtech.plateformAPI.Auth.ApiUser;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtTokenUtil {
	private static final Logger Logger = LoggerFactory.getLogger(JwtTokenUtil.class);
	
	@Value("${jwtSecret}")
	private String jwtSecret;
	
	@Value("${jwtExpirationMs}")
	private int jwtExpiration;
	
	//signs token 
	public String generateJwtToken(Authentication authentication) {
		ApiUser userPricipal = (ApiUser) authentication.getPrincipal();
		
		//builds token and signs it
		return Jwts.builder()
				.setSubject(userPricipal.getUsername())
				.setIssuer(userPricipal.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpiration))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	
	//gets username/subject of request
		public String getIdFromJwtToken(String returntoken) {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(returntoken).getBody().getIssuer();
		}
	//gets username/subject of request
	public String getUsernameFromJwtToken(String returntoken) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(returntoken).getBody().getSubject();
	}
	
	//validates authtoken
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			Logger.error("Invalid Jwt Signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			Logger.error("Invalid Jwt Token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			Logger.error("Jwt Token expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			Logger.error("Jwt Token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			Logger.error("Jwt claims string is empty: {}", e.getMessage());
		}
		return false;
	}
}
