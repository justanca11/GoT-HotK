package app;

import java.util.ArrayList;

import components.elements.board.Board;
import components.player.Player;

public class Game {
	private Board board;
	private ArrayList<Player> players;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void initializeGame(int playerNo) {
		Board board = new Board(6, 6);
		board.initializeBoard();
		this.board = board;
		players = new ArrayList<Player>(playerNo);
		for (int i = 1; i <= playerNo; i++) {
			players.add(new Player(i));
		}
		players.get(0).doTurn(board);
	}
	
}
