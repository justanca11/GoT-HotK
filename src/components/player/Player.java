package components.player;

import components.elements.board.Board;

public class Player {
	private int number = 1;

	// how many cards of each house the player has
	private int starkCards = 0;
	private int greyjoyCards = 0;
	private int lannisterCards = 0;
	private int targayrenCards = 0;
	private int baratheonCards = 0;
	private int tyrellCards = 0;
	private int tullyCards = 0;
	
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStarkCards() {
		return starkCards;
	}

	public void setStarkCards(int starkCards) {
		this.starkCards = starkCards;
	}

	public int getGreyjoyCards() {
		return greyjoyCards;
	}

	public void setGreyjoyCards(int greyjoyCards) {
		this.greyjoyCards = greyjoyCards;
	}

	public int getLannisterCards() {
		return lannisterCards;
	}

	public void setLannisterCards(int lannisterCards) {
		this.lannisterCards = lannisterCards;
	}

	public int getTargayrenCards() {
		return targayrenCards;
	}

	public void setTargayrenCards(int targayrenCards) {
		this.targayrenCards = targayrenCards;
	}

	public int getBaratheonCards() {
		return baratheonCards;
	}

	public void setBaratheonCards(int baratheonCards) {
		this.baratheonCards = baratheonCards;
	}

	public int getTyrellCards() {
		return tyrellCards;
	}

	public void setTyrellCards(int tyrellCards) {
		this.tyrellCards = tyrellCards;
	}

	public int getTullyCards() {
		return tullyCards;
	}

	public void setTullyCards(int tullyCards) {
		this.tullyCards = tullyCards;
	}

	public Player() {
		this.number++;
	}
	
	public Player(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Player " + number;
	}
	

	public enum Direction {
		UP, RIGHT, DOWN, LEFT
	}
	
	public void doTurn(Board b) {
		// 1. choose direction and house
		// 2. check if direction is valid
		// 3. move varys
		// 4. grab the cards
		// 5. update sizes (player + board)
		// 6. check if player needs to get sth (banner/companion card) / lose sth
		// 7. check if player uses sth (???)
	}
}
