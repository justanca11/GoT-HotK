package interaction;

import java.util.Scanner;

import util.enums.Direction;
import util.enums.House;

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
			// validate user input
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
			// validate user input
			try {
				direction = Direction.valueOf(directionString.toUpperCase());
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
				System.out.println(directionString
						+ " is not a valid direction, please choose between UP, RIGHT, DOWN and LEFT (not case sensitive).");
			}

		}
		return direction;
	}

	// TODO: double check
	public static int promptChooseStopCell(Scanner scanner) {
		int cellNo = -2; // TODO: better initialisation? -2 would never exist obviously
		String cellNoString = null;
		while (cellNo == -2) {
			// prompt user to choose stop cell
			System.out.println("\nChoose stop cell (cell numbering starts at 0):");
			// read user input
			cellNoString = scanner.nextLine();
			try {
				cellNo = Integer.parseInt(cellNoString);
			} catch (NumberFormatException e) {
				// e.printStackTrace();
				System.out.println("That is not valid input. Please choose a number between 0 and 5.");
			}
			// validate user input
			if (cellNo != -2 && (cellNo < 0 || cellNo > 5)) {
				cellNo = -2;
				System.out.println("That is not valid input. Please choose a number between 0 and 5.");
			}
		}
		return cellNo;
	}
}
