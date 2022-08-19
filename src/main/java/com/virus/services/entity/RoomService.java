package com.virus.services.entity;

import org.springframework.stereotype.Service;

import com.virus.model.database.entity.RoomEntity;
import com.virus.model.database.repository.RoomRepository;
import com.virus.model.dtos.RoomDTO;
import com.virus.services.dto.AbstractDtoConverterService;

@Service
public class RoomService extends AbstractEntityService<RoomEntity, RoomDTO, AbstractDtoConverterService<RoomEntity, RoomDTO>, RoomRepository, Long> {

}
