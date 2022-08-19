package com.virus.model.database.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1327513979893047065L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private RoomEntity room;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "player_id", referencedColumnName = "id")
	private PlayerEntity activePlayer;
	
	@ManyToMany
	@JoinTable(
	  name = "game_deck", 
	  joinColumns = @JoinColumn(name = "game_id"), 
	  inverseJoinColumns = @JoinColumn(name = "card_id"))
	private List<CardEntity> deck;
	
	@ManyToMany
	@JoinTable(
	  name = "game_trash", 
	  joinColumns = @JoinColumn(name = "game_id"), 
	  inverseJoinColumns = @JoinColumn(name = "trash_id"))
	private List<CardEntity> trash;
}
