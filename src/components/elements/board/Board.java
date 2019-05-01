package components.elements.board;

import java.util.ArrayList;
import java.util.Collections;

import components.elements.House;
import components.elements.cards.Card;
import components.elements.cards.CharacterCard;
import components.elements.cards.VarysCard;

public class Board {
	private int rows;
	private int columns;
	private Card[][] cards;
	private VarysCard varys;
	
	public VarysCard getVarys() {
		return varys;
	}

	// on board house deck sizes
	private int starkCards;
	private int greyjoyCards;
	private int lannisterCards;
	private int targaryenCards;
	private int baratheonCards;
	private int tyrellCards;
	private int tullyCards;

	public Card[][] getCards() {
		return cards;
	}

	public void setCards(Card[][] cards) {
		this.cards = cards;
	}

	public int getRows() {
		return rows;
	}

	/*
	 * public void setRows(int rows) { this.rows = rows; }
	 */

	public int getColumns() {
		return columns;
	}

	/*
	 * public void setColumns(int columns) { this.columns = columns; }
	 */
	
	

	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	/*
	 * @Override public String toString() { return "Board size: " + rows + " x " +
	 * columns + "."; }
	 */

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

	public int getTargaryenCards() {
		return targaryenCards;
	}

	public void setTargaryenCards(int targaryenCards) {
		this.targaryenCards = targaryenCards;
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

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void initializeBoard() {
		ArrayList<Card> cards = createBoardCards();
		Collections.shuffle(cards);
		this.cards = new Card[this.rows][this.columns];

		int row = 0, col = 0;
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).setX(row);
			cards.get(i).setY(col);
			this.cards[row][col] = cards.get(i);
			col++;
			if (col == 6) {
				col = 0;
				row++;
			}
		}
	}

	ArrayList<Card> createBoardCards() {
		ArrayList<Card> allBoardCards = new ArrayList<Card>(36);

		// 8 Stark cards
		allBoardCards.add(new CharacterCard(House.STARK, "Arya"));
		allBoardCards.add(new CharacterCard(House.STARK, "Bran"));
		allBoardCards.add(new CharacterCard(House.STARK, "Carlyn"));
		allBoardCards.add(new CharacterCard(House.STARK, "Eddard"));
		allBoardCards.add(new CharacterCard(House.STARK, "Lyanna"));
		allBoardCards.add(new CharacterCard(House.STARK, "Rickon"));
		allBoardCards.add(new CharacterCard(House.STARK, "Robb"));
		allBoardCards.add(new CharacterCard(House.STARK, "Sansa"));
		starkCards = 8;

		// 7 Greyjoy cards
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Aeron"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Asha"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Balon"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Euron"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Rodrik"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Theon"));
		allBoardCards.add(new CharacterCard(House.GREYJOY, "Victarion"));
		greyjoyCards = 7;

		// 6 Lannister cards
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Cersei"));
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Jaime"));
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Joffrey"));
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Kevan"));
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Tyrion"));
		allBoardCards.add(new CharacterCard(House.LANNISTER, "Tywin"));
		lannisterCards = 6;

		// 5 Targaryen cards
		allBoardCards.add(new CharacterCard(House.TARGARYEN, "Aegon 1"));
		allBoardCards.add(new CharacterCard(House.TARGARYEN, "Aerys"));
		allBoardCards.add(new CharacterCard(House.TARGARYEN, "Daenerys"));
		allBoardCards.add(new CharacterCard(House.TARGARYEN, "Aegon 1"));
		allBoardCards.add(new CharacterCard(House.TARGARYEN, "Viserys"));
		targaryenCards = 5;

		// 4 Baratheon cards
		allBoardCards.add(new CharacterCard(House.BARATHEON, "Renly"));
		allBoardCards.add(new CharacterCard(House.BARATHEON, "Shireen"));
		allBoardCards.add(new CharacterCard(House.BARATHEON, "Stannis"));
		allBoardCards.add(new CharacterCard(House.BARATHEON, "Robert"));
		baratheonCards = 4;

		// 3 Tyrell cards
		allBoardCards.add(new CharacterCard(House.TYRELL, "Garlan"));
		allBoardCards.add(new CharacterCard(House.TYRELL, "Margaery"));
		allBoardCards.add(new CharacterCard(House.TYRELL, "Olenna"));
		tyrellCards = 3;

		// 2 Tully cards
		allBoardCards.add(new CharacterCard(House.TULLY, "Edmure"));
		allBoardCards.add(new CharacterCard(House.TULLY, "Hoster"));
		tullyCards = 2;

		// & last but not least - Varys
		VarysCard varys = new VarysCard("Varys");
		allBoardCards.add(varys);
		this.varys = varys;
		

		return allBoardCards;
	}
}
