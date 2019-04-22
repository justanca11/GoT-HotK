package components.elements.board;

import java.util.ArrayList;

import components.elements.cards.Card;

public class Board {
	private int rows;
	private int columns;
	private Card[][] cards;
	
	

	public Card[][] getCards() {
		return cards;
	}

	public void setCards(Card[][] cards) {
		this.cards = cards;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
	}

	@Override
	public String toString() {
		return "Board size: " + rows + " x " + columns + ".";
	}
}
