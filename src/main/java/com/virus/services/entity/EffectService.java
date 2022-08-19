package com.virus.services.entity;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.EffectEntity;
import com.virus.model.database.repository.EffectRepository;
import com.virus.model.dtos.EffectDTO;
import com.virus.services.dto.AbstractDtoConverterService;

@Service
public class EffectService extends AbstractEntityService<EffectEntity, EffectDTO, AbstractDtoConverterService<EffectEntity, EffectDTO>, EffectRepository, Long> {

}
