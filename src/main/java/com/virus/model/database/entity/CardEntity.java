package com.virus.model.database.entity;

import java.util.List;

import com.virus.model.enumerateds.CardType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private CardType type;
	
	@ManyToMany(mappedBy = "deck")
	private List<GameEntity> gamesDeck;
	
	@ManyToMany(mappedBy = "trash")
	private List<GameEntity> gamesTrash;
}
