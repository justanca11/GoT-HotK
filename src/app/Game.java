package app;

import java.util.ArrayList;

import components.elements.House;
import components.elements.board.Board;
import components.elements.cards.Card;
import components.elements.cards.CharacterCard;
import components.elements.cards.VarysCard;

public class Game {
	private Board board;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void initializeGame() {
		Board board = new Board(6,6);
		board.initializeBoard();
		this.board = board;
	}
}
