package com.virus.model.dtos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.virus.model.enumerateds.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUserDTO {

	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String birthDate;
		
	private LocalDateTime createTime;
	
	private LocalDateTime updateTime;
		
	private LocalDateTime lastPasswordChange;
	
	private LocalDateTime nextPasswordChange;
	
	private Boolean enableAccount;
	
	private Set<UserRole> roles;

	private String activationCode;
	
	private String imageProfile;


}
