package com.virus.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.virus.model.dtos.AppUserDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter
public class UsernamePasswordAuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	@SuppressWarnings("unused")
	@Autowired
	private PasswordEncoder passEncoder;
	
	@SuppressWarnings("static-access")
	public UsernamePasswordAuthenticationFilterImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(SecurityConstants.SIGN_IN);
    }
	
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		AppUserDTO user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), AppUserDTO.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (InternalAuthenticationServiceException e) {
				logger.info("No se puede crear la respuesta de un login incorrecto");
			
		}
		System.out.println(user.getUsername() + ": " + user.getPassword());
		try {
			Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			
			return auth;
		} catch (AuthenticationException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + JWTTokenProvider.generateToken(authResult));
		
	}
}
