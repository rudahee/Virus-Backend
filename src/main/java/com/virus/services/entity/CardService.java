package com.virus.services.entity;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.CardEntity;
import com.virus.model.database.repository.CardRepository;
import com.virus.model.dtos.CardDTO;
import com.virus.services.dto.AbstractDtoConverterService;

@Service
public class CardService extends AbstractEntityService<CardEntity, CardDTO, AbstractDtoConverterService<CardEntity, CardDTO>, CardRepository, Long>  {
	
	public boolean existsAnyCard() {
		boolean exists = (repository.count() > 0) ? true : false;
		
		return exists;
	}
}
