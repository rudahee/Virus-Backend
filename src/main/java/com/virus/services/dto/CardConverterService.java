package com.virus.services.dto;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.CardEntity;
import com.virus.model.dtos.CardDTO;

@Service
public class CardConverterService extends AbstractDtoConverterService<CardEntity, CardDTO> {

	@Override
	public CardEntity fromDto(CardDTO dto) {
		CardEntity entity = new CardEntity();
		
		entity.setDescription(dto.getDescription());
		entity.setName(dto.getName());
		entity.setType(dto.getType());
		
		return entity;
	}

	@Override
	public CardDTO fromEntity(CardEntity entity) {
		CardDTO dto = new CardDTO();
		
		dto.setDescription(entity.getDescription());
		dto.setName(entity.getName());
		dto.setType(entity.getType());
		
		return dto;
	}

}
