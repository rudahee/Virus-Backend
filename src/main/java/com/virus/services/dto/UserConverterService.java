package com.virus.services.dto;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.AppUser;
import com.virus.model.dtos.AppUserDTO;

@Service
public class UserConverterService extends AbstractDtoConverterService<AppUser, AppUserDTO>  {

	@Override
	public AppUser fromDto(AppUserDTO dto) {
		AppUser user  = new AppUser();
		
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setRoles(dto.getRoles());
		user.setEnableAccount(dto.getEnableAccount());
		
		return user;
	}

	@Override
	public AppUserDTO fromEntity(AppUser entity) {
		AppUserDTO dto = new AppUserDTO();
		
		dto.setId(entity.getId());
		dto.setEmail(entity.getEmail());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setRoles(entity.getRoles());
		dto.setEnableAccount(entity.getEnableAccount());
		dto.setLastPasswordChange(entity.getLastPasswordChange());
		dto.setNextPasswordChange(entity.getNextPasswordChange());
		dto.setCreateTime(entity.getCreateTime());
		dto.setUpdateTime(entity.getUpdateTime());

		return dto;
	}

}
