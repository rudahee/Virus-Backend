package com.virus.services.entity;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.PlayerEntity;
import com.virus.model.database.repository.PlayerRepository;
import com.virus.model.dtos.PlayerDTO;
import com.virus.services.dto.AbstractDtoConverterService;

@Service
public class PlayerService extends AbstractEntityService<PlayerEntity, PlayerDTO, AbstractDtoConverterService<PlayerEntity, PlayerDTO>, PlayerRepository, Long> {

}
