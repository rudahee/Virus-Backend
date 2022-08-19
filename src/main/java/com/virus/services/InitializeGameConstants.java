package com.virus.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virus.model.database.entity.CardEntity;
import com.virus.model.database.repository.CardRepository;
import com.virus.model.enumerateds.CardType;

@Service
public class InitializeGameConstants {
	

	@Autowired 
	private CardRepository repository;

	private CardEntity specialBody = new CardEntity();
	private CardEntity specialVirus = new CardEntity();
	private CardEntity specialMedicament = new CardEntity();
	
	private ArrayList<CardEntity> organosCard = new ArrayList<CardEntity>();
	private ArrayList<CardEntity> medicamentsCard = new ArrayList<CardEntity>();
	private ArrayList<CardEntity> virusCard = new ArrayList<CardEntity>();
	
	
	public boolean existsAnyCards() {
		return repository.findAll().isEmpty();
	}
	
	public void initializeCards() {
		this.generateOrgansCards();
		this.generateVirusCards();
		this.generateMedicamentCards();
		
		for (CardEntity card: organosCard) {
			repository.save(card);
		}
		for (CardEntity card: virusCard) {
			repository.save(card);
		}
		for (CardEntity card: medicamentsCard) {
			repository.save(card);
		}
		
		repository.save(specialBody);
		repository.save(specialVirus);	
		repository.save(specialMedicament);
	}
	
	private void generateVirusCards() {
		CardEntity hearth = new CardEntity();
		hearth.setName("Infartito");
		hearth.setDescription("Puedes infectar un corazon con este virus.");
		hearth.setType(CardType.CORAZON);
		CardEntity stomach = new CardEntity();
		stomach.setName("Diarrea");
		stomach.setDescription("Puedes infectar un estomago con este virus.");
		stomach.setType(CardType.ESTOMAGO);
		CardEntity bones = new CardEntity();
		bones.setName("Osteomielitis");
		bones.setDescription("Puedes infectar un puñado de huesos con este virus.");
		bones.setType(CardType.HUESO);
		CardEntity brain = new CardEntity();
		brain.setName("Sindrome de Down");
		brain.setDescription("Puedes infectar un cerebro con este virus.");
		brain.setType(CardType.CEREBRO);
		
		virusCard.add(hearth);
		virusCard.add(stomach);
		virusCard.add(bones);
		virusCard.add(brain);
		
		specialVirus.setName("Cancer");
		specialVirus.setDescription("Puedes infectar a cualquier organo con este virus.");
		specialVirus.setType(CardType.ORGANO_ESPECIAL);
	}
	
	private void generateOrgansCards() {
		CardEntity hearth = new CardEntity();
		hearth.setName("Corazon");
		hearth.setDescription("¡Si consigues reunir otras 3 cartas de organo ganaras el juego!");
		hearth.setType(CardType.CORAZON);
		CardEntity stomach = new CardEntity();
		stomach.setName("Estomago");
		stomach.setDescription("¡Si consigues reunir otras 3 cartas de organo ganaras el juego!");
		stomach.setType(CardType.ESTOMAGO);
		CardEntity bones = new CardEntity();
		bones.setName("Huesos");
		bones.setDescription("¡Si consigues reunir otras 3 cartas de organo ganaras el juego!");
		bones.setType(CardType.HUESO);
		CardEntity brain = new CardEntity();
		brain.setName("Cerebro");
		brain.setDescription("¡Si consigues reunir otras 3 cartas de organo ganaras el juego!");
		brain.setType(CardType.CEREBRO);
		
		organosCard.add(hearth);
		organosCard.add(stomach);
		organosCard.add(bones);
		organosCard.add(brain);
		
		specialBody.setName("Cuerpo Comodin");
		specialBody.setDescription("¡Si consigues reunir otras 3 cartas de organo ganaras el juego!");
		specialBody.setType(CardType.ORGANO_ESPECIAL);
	}
	
	private void generateMedicamentCards() {
		CardEntity hearth = new CardEntity();
		hearth.setName("Sintron");
		hearth.setDescription("Que no te den trombos :)");
		hearth.setType(CardType.CORAZON);
		CardEntity stomach = new CardEntity();
		stomach.setName("Laxante");
		stomach.setDescription("¡Sacalo todo!");
		stomach.setType(CardType.ESTOMAGO);
		CardEntity bones = new CardEntity();
		bones.setName("Escayola");
		bones.setDescription("¿Te lo puedo firmar?");
		bones.setType(CardType.HUESO);
		CardEntity brain = new CardEntity();
		brain.setName("Lorazepam");
		brain.setDescription("Tranquilito, bro");
		brain.setType(CardType.CEREBRO);
		
		medicamentsCard.add(hearth);
		medicamentsCard.add(stomach);
		medicamentsCard.add(bones);
		medicamentsCard.add(brain);
		
		specialMedicament.setName("Ibuprofeno y mucha agua");
		specialMedicament.setDescription("¡Ah! Y mucho reposo.");
		specialMedicament.setType(CardType.ORGANO_ESPECIAL);
	}
	
}
