package com.virus.services.dto;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.EffectEntity;
import com.virus.model.dtos.EffectDTO;

@Service
public class EffectConverterService extends AbstractDtoConverterService<EffectEntity, EffectDTO> {

	@Override
	public EffectEntity fromDto(EffectDTO dto) {
		EffectEntity entity = new EffectEntity();
		
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setValue(dto.getValue());
		
		return entity;
	}

	@Override
	public EffectDTO fromEntity(EffectEntity entity) {
		EffectDTO dto = new EffectDTO();
		
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setValue(entity.getValue());
		
		return dto;
	}

}
