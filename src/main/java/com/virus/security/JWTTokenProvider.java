package com.virus.security;

import java.util.Date;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.virus.model.database.entity.AppUser;
import com.virus.model.enumerateds.ErrorCode;
import com.virus.model.enumerateds.UserRole;
import com.virus.model.exceptions.JwtException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;


@Service
public class JWTTokenProvider { 

	private static SecretKey key; 
	
	/* This method generates a token for the user who is logging in. 
	 * 
	 * @param authentication Authentication
	 * 
	 * @return String (but its a JWT Token)
	 */
	public static String generateToken(Authentication authentication) {
		
		AppUser user = (AppUser) authentication.getPrincipal();
        return Jwts.builder()
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE) 
				.setSubject(user.getEmail().toString())  														// User Email Header in Token
				.setId(user.getId().toString())																	// Id user header in token
				.setIssuedAt(new Date(System.currentTimeMillis())) 												// Date and Time Creation Token
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)) 		// Date and Time Expiration Token
				.claim("roles", user.getRoles().stream().map(UserRole::name).collect(Collectors.joining(", "))) // Claim with roles
				.signWith(getKey(), SignatureAlgorithm.HS512)
				.compact();
	}
	
	/* This method validate a token for each request. 
	 * 
	 * @param token String
	 * 
	 * @return boolean
	 */
	public static boolean validateToken(String token) throws JwtException {
		boolean valid = false;
		
		try {
			Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token);
			valid = true;
		} catch (SignatureException ex) {
			throw new JwtException(ErrorCode.TOKEN_NOT_VALID);
		} catch (MalformedJwtException ex) {
			throw new JwtException(ErrorCode.TOKEN_NOT_VALID);
		} catch (ExpiredJwtException ex) {
			throw new JwtException(ErrorCode.TOKEN_EXPIRED);
		} catch (UnsupportedJwtException ex) {
			throw new JwtException(ErrorCode.TOKEN_NOT_VALID);
		} catch (IllegalArgumentException ex) {
			throw new JwtException(ErrorCode.TOKEN_NOT_VALID);
		}
		
		return valid;
	}
	
	/* This method retrieve id from token. 
	 * 
	 * @param token String
	 * 
	 * @return Long
	 */
	public static Long getIdFromToken(String token) {
		return Long.valueOf((String) Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().get("jti"));
	}
	
	private static  SecretKey getKey() {
		if(key == null) {
			key = Keys.hmacShaKeyFor(SecurityConstants.SECRET.getBytes());
		}
		return key;
	}
}
