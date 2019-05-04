package app;

import java.util.ArrayList;

import components.elements.board.Board;
import components.player.Player;
import interaction.ConsoleInteraction;

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

		// game loop
		int j = 0;
		while (this.board.getVarys().isMovable(this.board.getCards()) == true) {
			boolean isTurnComplete = players.get(j).doTurn(board);
			// if the current player completed their turn, next one's turn; otherwise the current player again
			if (isTurnComplete == true) {
				if (j == 0) {
					j = 1;
				} else {
					j = 0;
				}
			}
		}
		System.out.println("Game end.");
		ConsoleInteraction.scanner.close();
	}

}
