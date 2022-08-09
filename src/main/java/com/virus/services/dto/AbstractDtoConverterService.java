package com.virus.services.dto;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDtoConverterService<E, D> {
	/*
	 * E -> Entity
	 * 
	 * D -> Dto
	 */
	
	//Each implement do same thing: collect all the attributes of the DTO and parse it to the entity
	public abstract E fromDto(D dto);
		
	//Each implement do same thing: collect all the attributes of the Entity and parse it to the DTO. Relations excludes
	public abstract D fromEntity(E entity);
	
	// Do fromEntity for each entity in list.
	public List<D> fromEntities(List<E> entities) {
		List<D> dtos = new ArrayList<D>();
		entities.forEach(entity -> {
			dtos.add(this.fromEntity(entity));
		});
		
		return dtos;
	}
	
	// Do fromDto for each dto in list.
	public List<E> fromDtos(List<D> dtos) {
		List<E> entities = new ArrayList<E>();
		dtos.forEach(dto -> {
			entities.add(this.fromDto(dto));
		});
		
		return entities;
	}
}
