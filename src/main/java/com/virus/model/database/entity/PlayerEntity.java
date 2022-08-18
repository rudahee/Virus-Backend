package com.virus.model.database.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = false, nullable = false)
	private String publicUsername;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private AppUser user;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="room_id", nullable=true)
	private RoomEntity room;
	
	@OneToOne(mappedBy = "activePlayer")
	private GameEntity game;

}
