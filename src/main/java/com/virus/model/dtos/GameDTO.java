package com.virus.model.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.virus.model.database.entity.CardEntity;
import com.virus.model.database.entity.PlayerEntity;
import com.virus.model.database.entity.RoomEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

	private RoomEntity room;

	private PlayerEntity activePlayer;

	private List<CardEntity> deck;

	private List<CardEntity> trash;
	
}
