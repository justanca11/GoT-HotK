package interaction;

import java.util.Scanner;

import components.elements.House;
import components.player.Player.Direction;

// TODO: rename?
public class ConsoleInteraction {
	public static House promptChooseHouse(Scanner scanner) {
		House house = null;
		String houseString = null;
		while (house == null) {
			// prompt user to choose house
			System.out.println("\nChoose house (Stark, Grejoy, Lannister, Targaryen, Baratheon, Tyrell, Tully):");
			// read user input
			houseString = scanner.nextLine();
			// check if the input represents a valid house
			try {
				house = House.valueOf(houseString.toUpperCase());
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
				System.out.println(houseString
						+ " is not a valid house, please choose between houses Stark, Grejoy, Lannister, Targaryen, Baratheon, Tyrell and Tully (not case sensitive).");
			}
		}
		return house;
	}

	public static Direction promptChooseDirection(Scanner scanner) {
		Direction direction = null;
		String directionString = null;
		while (direction == null) {
			// prompt user to choose direction
			System.out.println("\nChoose direction (UP, RIGHT, DOWN, LEFT):");
			// read user input
			directionString = scanner.nextLine();
			// check if the input represents a valid house
			try {
				direction = Direction.valueOf(directionString.toUpperCase());
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
				System.out.println(directionString
						+ " is not a valid direction, please pick between UP, RIGHT, DOWN and LEFT (not case sensitive).");
			}

		}
		return direction;
	}
	
	// TODO: finish
	public static int promptChooseStopCell(Scanner scanner) {
		System.out.println("\nChoose stop cell (cell numbering starts at 0):");
		return scanner.nextInt();
	}
}
