package com.virus.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.virus.model.enumerateds.CardType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDTO {

	private String name;
	
	private String description;
	
	@Enumerated(EnumType.STRING)
	private CardType type;
	
}
