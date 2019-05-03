package app;

import java.util.Scanner;

import components.elements.House;
import components.elements.board.Board;
import components.player.Player.Direction;
import interaction.ConsoleInteraction;


public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Game starting...");

		System.out.println("Game set up...");

		Game game = new Game();
		game.initializeGame(2);
		
		//Scanner scanner = new Scanner(System.in);
			
		// test
		/*printBoard(game.getBoard());
		System.out.println();
		System.out.println(game.getPlayers());*/
		

		long endTime = System.nanoTime();
		System.out.println("\n\nGame run took " + (endTime - startTime) / 1_000_000_000.0 + " seconds.");
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
