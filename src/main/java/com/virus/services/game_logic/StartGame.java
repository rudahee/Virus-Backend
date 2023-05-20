package com.virus.services.game_logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virus.model.dtos.CardDTO;
import com.virus.model.dtos.PlayerDTO;
import com.virus.model.dtos.game.GameStartDTO;
import com.virus.services.entity.CardService;
import com.virus.services.entity.PlayerService;

@Service
public class StartGame {
	
	@Autowired
	private CardService cardService;
	
	@Autowired PlayerService playerService;

	public GameStartDTO startGame(GameStartDTO initialStatus) {
		
		initialStatus = this.createZones(initialStatus);
		initialStatus = this.shuffleDeck(initialStatus);
		initialStatus = this.drawFirstCards(initialStatus);
		
		GameStartDTO finalStatus = this.saveActualStatus(initialStatus);
				
		return finalStatus;
		
	}

	
	private GameStartDTO saveActualStatus(GameStartDTO initialStatus) {

		for (PlayerDTO player: initialStatus.getActivePlayers()) {
			playerService.save(player);
		}
		
		return null;
	}


	@SuppressWarnings("serial")
	private GameStartDTO drawFirstCards(GameStartDTO initialStatus) {

		List<CardDTO> drawedCards;
		for (PlayerDTO player: initialStatus.getActivePlayers()) {
			
			drawedCards = new ArrayList<CardDTO>() {{
				add(initialStatus.getDeck().poll());
				add(initialStatus.getDeck().poll());
				add(initialStatus.getDeck().poll());			
			}};
			
			player.setCards(drawedCards);

		}
		
		
		return initialStatus;
	}


	private GameStartDTO shuffleDeck(GameStartDTO initialStatus) {

		Random rng = new Random();
		
		Collections.shuffle(initialStatus.getDeck(), rng);
		
		return initialStatus;
	}


	private GameStartDTO createZones(GameStartDTO initialStatus) {
		
		List<CardDTO> deckList = cardService.findAll();
		
		initialStatus.setDeck(new LinkedList<>(deckList));
		
		initialStatus.setTrash(new ArrayList<CardDTO>());
		
		for (PlayerDTO player: initialStatus.getActivePlayers()) {
			player.setCards(new ArrayList<CardDTO>());
		}
		return initialStatus;
	}
}
