package com.virus.security;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.virus.model.database.entity.AppUser;
import com.virus.model.exceptions.JwtException;
import com.virus.services.entity.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
@WebFilter
public class OncePerRequestFilterImpl extends OncePerRequestFilter {

	@Autowired
	private UserService userService;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader(SecurityConstants.TOKEN_HEADER);

		// if header doesnt starts with 'Bearer '
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        
        UsernamePasswordAuthenticationToken authentication;
        
        try {
        	authentication = this.getAuthentication(request);        	
        	authentication.setDetails(new WebAuthenticationDetails(request));
        	SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (JwtException | AuthenticationException e) {
         	logger.info("Error in authentication");
   		}
        
        
        chain.doFilter(request, response);
	}
	
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws JwtException, AuthenticationException {
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER).replace(SecurityConstants.TOKEN_PREFIX, "");
        UsernamePasswordAuthenticationToken upat = null;
        
        if (token != null && !token.isEmpty() && JWTTokenProvider.validateToken(token)) {
        	Long idUser = Long.valueOf(Jwts.parser().
										setSigningKey(Keys.hmacShaKeyFor(SecurityConstants.SECRET.getBytes()))
										.parseClaimsJws(token)
										.getBody()
										.getId());
     	
			AppUser user = (AppUser) userService.loadUserById(idUser);
			if (idUser != null) {
				upat = new UsernamePasswordAuthenticationToken(idUser, user.getRoles(), user.getAuthorities());
			} 
        }
        return upat;	
    }

}
