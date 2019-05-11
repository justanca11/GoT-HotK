package components.elements.cards;

import components.behaviour.Arrangeable;
import util.ConsoleColours;
import util.House;

public class CharacterCard extends Card implements Arrangeable {
	private House house;
	// private String photo; // TODO: change data type then uncomment

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	// TODO: add photo
	public CharacterCard(House house, String name) {
		super(name);
		this.house = house;
	}

	@Override
	public String toString() {
		switch (house) {
		case STARK:
			return ConsoleColours.ANSI_GREY_STARK + super.getName() + " " + house.toString() + " is at position " + "("
					+ getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		case GREYJOY:
			return ConsoleColours.ANSI_BLACK_GREYJOY + super.getName() + " " + house.toString() + " is at position "
					+ "(" + getX() + "," + getY() + ") " + ConsoleColours.ANSI_RESET;
		case LANNISTER:
			return ConsoleColours.ANSI_RED_LANNISTER + super.getName() + " " + house.toString() + " is at position "
					+ "(" + getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		case TARGARYEN:
			return ConsoleColours.ANSI_DARK_RED_TARGARYEN + super.getName() + " " + house.toString()
					+ " is at position " + "(" + getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		case BARATHEON:
			return ConsoleColours.ANSI_YELLOW_BARATHEON + super.getName() + " " + house.toString() + " is at position "
					+ "(" + getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		case TYRELL:
			return ConsoleColours.ANSI_GREEN_TYRELL + super.getName() + " " + house.toString() + " is at position "
					+ "(" + getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		case TULLY:
			return ConsoleColours.ANSI_LIGHT_BLUE_TULLY + super.getName() + " " + house.toString() + " is at position "
					+ "(" + getX() + "," + getY() + ")" + ConsoleColours.ANSI_RESET;
		default:
			// not reached
			return "Something went horribly wrong";
		}
	}

}
