package com.virus.model.database.entity;

import java.io.Serializable;
import java.util.List;

import com.virus.model.enumerateds.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity implements Serializable {

	private static final long serialVersionUID = -7218161443582260085L;

	@Id
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private Status status;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "room", cascade = CascadeType.ALL)
	private List<PlayerEntity> players;
    
	@OneToOne(mappedBy = "room")
    private GameEntity game;
}
