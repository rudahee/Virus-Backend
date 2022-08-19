package com.virus.services.dto;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.PlayerEntity;
import com.virus.model.dtos.PlayerDTO;

@Service
public class PlayerConverterService extends AbstractDtoConverterService<PlayerEntity, PlayerDTO> {

	@Override
	public PlayerEntity fromDto(PlayerDTO dto) {
		PlayerEntity entity = new PlayerEntity();
		
		entity.setPublicUsername(dto.getPublicUsername());
		
		return entity;
	}

	@Override
	public PlayerDTO fromEntity(PlayerEntity entity) {
		PlayerDTO dto = new PlayerDTO();

		dto.setPublicUsername(entity.getPublicUsername());
		
		return dto;
	}

}
