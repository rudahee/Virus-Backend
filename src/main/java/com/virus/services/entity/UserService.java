package com.virus.services.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.virus.model.database.entity.AppUser;
import com.virus.model.database.repository.AppUserRepository;
import com.virus.model.dtos.AppUserDTO;
import com.virus.model.enumerateds.ErrorCode;
import com.virus.model.enumerateds.UserRole;
import com.virus.model.exceptions.UserManagementException;
import com.virus.services.dto.AbstractDtoConverterService;

@Service
public class UserService extends AbstractEntityService<AppUser, AppUserDTO, AbstractDtoConverterService<AppUser, AppUserDTO>, AppUserRepository, Long> implements UserDetailsService{

	@Autowired
	protected PasswordEncoder passEncoder;

	
	public boolean existsById(Long id) {
		return this.repository.existsById(id);
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		return repository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
	}


	public UserDetails loadUserById(Long id) {
		return super.repository.findById(id).get();
	}

	public AppUserDTO signUpUser(AppUserDTO user) throws UserManagementException {
		
		if (repository.existsUserByEmail(user.getEmail())) {
			throw new UserManagementException(ErrorCode.EMAIL_ALREADY_EXISTS);
		} else if(repository.existsUserByUsername(user.getUsername())) {
			throw new UserManagementException(ErrorCode.USERNAME_ALREADY_EXISTS);
		}
		
		String activationCode = UUID.randomUUID().toString().substring(0, 5);
		user.setActivationCode(activationCode);
		user.setEnableAccount(false);
		user.setRoles((Set<UserRole>) Set.of(UserRole.MEMBER));
		user.setPassword(passEncoder.encode(user.getPassword()));
		
		
		AppUser userObj = DtoConverter.fromDto(user);

		return DtoConverter.fromEntity(repository.save(userObj));
	}
	
	public void disableAccount(Long id, String reason) throws UserManagementException {
		if (!repository.existsById(id)) {
			throw new UserManagementException(ErrorCode.USER_NOT_EXIST);
		}
		@SuppressWarnings("deprecation")
		AppUser user = repository.getById(id);
		user.setDeleteTime(LocalDateTime.now());
		
		if (!reason.isEmpty() && !reason.isBlank() || reason != null) {
			user.setReasonForLockedAccount(reason);			
		}
		
		repository.save(user);		
	}
	

}
