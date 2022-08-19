package com.virus.model.database.entity;

import java.io.Serializable;
import java.util.List;

import com.virus.model.enumerateds.CardType;

import jakarta.persistence.CascadeType;
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
public class CardEntity implements Serializable {

	private static final long serialVersionUID = 7465349888953534316L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private CardType type;
	
	@ManyToMany(mappedBy = "cards", cascade = CascadeType.ALL)
	private List<EffectEntity> effects;
	
	@ManyToMany(mappedBy = "deck", cascade = CascadeType.ALL)
	private List<GameEntity> gamesDeck;
	
	@ManyToMany(mappedBy = "trash", cascade = CascadeType.ALL)
	private List<GameEntity> gamesTrash;
}
