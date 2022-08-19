package com.virus.model.database.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EffectEntity implements Serializable {

	private static final long serialVersionUID = 4275067460362037951L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String description;
	
	private Integer value;

	@ManyToMany
	@JoinTable(
	  name = "card_effect", 
	  joinColumns = @JoinColumn(name = "effect_id"), 
	  inverseJoinColumns = @JoinColumn(name = "card_id"))
	private List<CardEntity> cards;
	
}
