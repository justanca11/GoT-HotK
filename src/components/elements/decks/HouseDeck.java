package components.elements.decks;

import java.util.ArrayList;

import components.elements.House;
import components.elements.cards.CharacterCard;

public class HouseDeck {
	private House name;
	private ArrayList<CharacterCard> cards;

	public House getName() {
		return name;
	}

	public ArrayList<CharacterCard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<CharacterCard> cards) {
		this.cards = cards;
	}

	public HouseDeck(House name, int numberOfCards) {
		super();
		this.name = name;
		cards = new ArrayList<CharacterCard>(numberOfCards);
	}

	@Override
	public String toString() {
		String cardsString = String.join(",", cards.toString());
		return cards.size() + " cards: " + cardsString;
	}
}
