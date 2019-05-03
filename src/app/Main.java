package app;

import components.elements.board.Board;


public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Game starting...");

		System.out.println("Game set up...");

		Game game = new Game();
		game.initializeGame(2);

		long endTime = System.nanoTime();
		System.out.println("\n\nGame ran for... " + (endTime - startTime) / 1_000_000_000.0 + " seconds.");
	}



	public static void printBoard(Board b) {
		System.out.println("\nBoard info:");
		for (int i = 0; i < b.getRows(); i++) {	
			for (int j = 0; j < b.getColumns(); j++) {
				System.out.print(b.getCards()[i][j] + " | ");
			}
			System.out.println();
		}
	}
}
