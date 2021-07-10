package com.hussein.java_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hussein.java_project.models.Card;
import com.hussein.java_project.repositories.CardRepo;

@Service
public class CardService {
	private final CardRepo cardRepo;
	
	public CardService(CardRepo cardRepo) {
		this.cardRepo = cardRepo;
	}
	
	// Return All Cards
	public List<Card> allCards() {
		return (List<Card>) cardRepo.findAll();
	}
	
	// Create a card 
	public Card createCard(Card card) {
		return cardRepo.save(card);
	}
	
	//Get Card by ID
	public Card findCardById(Long id) {
		Optional<Card> optCard = cardRepo.findById(id);
		if(optCard.isPresent()) {
			return optCard.get();
		} else {
			return null;
		}
	}
	
	// Update Card
	public Card updateCard(Card card) {
		return cardRepo.save(card);
	}
	
	// Delete Card
	public void deleteCard(Long id) {
		Optional<Card> optCard = cardRepo.findById(id);
		if(optCard.isPresent()) {
			cardRepo.deleteById(id);
		}
	}
}
