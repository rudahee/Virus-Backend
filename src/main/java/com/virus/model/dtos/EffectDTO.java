package com.virus.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EffectDTO {

	private String name;
	
	private String description;
	
	private Integer value;
}
