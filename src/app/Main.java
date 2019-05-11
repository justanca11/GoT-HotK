package app;

import components.elements.board.Board;
import util.ConsoleColours;

public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Game starting...");

		System.out.println("Game set up...");

		// Game game = new Game();
		// game.initializeGame(2);

		/* Test console colours*/
		System.out.println();
		System.out.println(ConsoleColours.ANSI_GREY_STARK + "Stark" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_BLACK_GREYJOY + "Greyjoy" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_RED_LANNISTER + "Lannister" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_DARK_RED_TARGARYEN + "Targaryen" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_YELLOW_BARATHEON + "Baratheon" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_GREEN_TYRELL + "Tyrell" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_LIGHT_BLUE_TULLY + "Tully" + ConsoleColours.ANSI_RESET);
		System.out.println(ConsoleColours.ANSI_PURPLE_VARYS + "Varys" + ConsoleColours.ANSI_RESET);
		/* End test console colours*/
		
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
