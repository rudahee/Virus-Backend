package com.virus.model.dtos.game;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.virus.model.database.entity.RoomEntity;
import com.virus.model.dtos.CardDTO;
import com.virus.model.dtos.PlayerDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartDTO {
	
	private RoomEntity room;

	private List<PlayerDTO> activePlayers;

	private LinkedList<CardDTO> deck;

	private List<CardDTO> trash;
	
}
