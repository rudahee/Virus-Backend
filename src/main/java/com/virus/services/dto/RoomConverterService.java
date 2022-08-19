package com.virus.services.dto;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.RoomEntity;
import com.virus.model.dtos.RoomDTO;

@Service
public class RoomConverterService extends AbstractDtoConverterService<RoomEntity, RoomDTO>  {

	@Override
	public RoomEntity fromDto(RoomDTO dto) {
		RoomEntity entity = new RoomEntity();
		
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setStatus(dto.getStatus());
		
		return entity;
	}

	@Override
	public RoomDTO fromEntity(RoomEntity entity) {
		RoomDTO dto = new RoomDTO();
		
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
	
		return dto;
	}

}
