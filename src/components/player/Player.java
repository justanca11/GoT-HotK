package components.player;

import java.util.Scanner;

import app.Main;
import components.elements.House;
import components.elements.board.Board;
import components.elements.cards.Card;
import components.elements.cards.CharacterCard;
import components.elements.cards.VarysCard;

public class Player {
	private int number = 1;

	// how many cards of each house the player has
	private int starkCards = 0;
	private int greyjoyCards = 0;
	private int lannisterCards = 0;
	private int targaryenCards = 0;
	private int baratheonCards = 0;
	private int tyrellCards = 0;
	private int tullyCards = 0;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStarkCards() {
		return starkCards;
	}

	public void setStarkCards(int starkCards) {
		this.starkCards = starkCards;
	}

	public int getGreyjoyCards() {
		return greyjoyCards;
	}

	public void setGreyjoyCards(int greyjoyCards) {
		this.greyjoyCards = greyjoyCards;
	}

	public int getLannisterCards() {
		return lannisterCards;
	}

	public void setLannisterCards(int lannisterCards) {
		this.lannisterCards = lannisterCards;
	}

	public int getTargarenCards() {
		return targaryenCards;
	}

	public void setTargayrenCards(int targayrenCards) {
		this.targaryenCards = targayrenCards;
	}

	public int getBaratheonCards() {
		return baratheonCards;
	}

	public void setBaratheonCards(int baratheonCards) {
		this.baratheonCards = baratheonCards;
	}

	public int getTyrellCards() {
		return tyrellCards;
	}

	public void setTyrellCards(int tyrellCards) {
		this.tyrellCards = tyrellCards;
	}

	public int getTullyCards() {
		return tullyCards;
	}

	public void setTullyCards(int tullyCards) {
		this.tullyCards = tullyCards;
	}

	public Player() {
		this.number++;
	}

	public Player(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Player " + number;
	}

	public enum Direction {
		UP, RIGHT, DOWN, LEFT
	}

	public void doTurn(Board b) {
		// show curr board
		Main.printBoard(b);
		VarysCard v = b.getVarys();
		System.out.println(v);
		System.out.println();

		String houseString = null;

		// 1.1. choose house
		House house = null;
		while (house == null) {
			System.out.println("Choose house [STARK, GREYJOY, LANNISTER, TARGARYEN, BARATHEON, TYRELL, TULLY]: ");

			Scanner scanner = new Scanner(System.in);
			houseString = scanner.nextLine();

			System.out.println("House: " + houseString);
			// 1.2. check if house is valid

			try {
				house = House.valueOf(houseString.toUpperCase());

			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
				System.out.println(house
						+ " is not a valid house, please pick between STARK, GREYJOY, LANNISTER, TARGARYEN, BARATHEON, TYRELL, TULLY.");
				house = null;
			}
		}

		// 2.1 choose direction

		Direction direction = null;
		while (direction == null) {

			System.out.println("Choose direction [UP, RIGHT, DOWN, LEFT]: ");

			Scanner scanner = new Scanner(System.in);
			String directionString = scanner.nextLine();

			System.out.println("Direction: " + directionString);
			// 2.2 check if direction is valid + 3. move varys together + 4. "grab"(for now
			// remove) the cards cus switch

			try {
				direction = Direction.valueOf(directionString.toUpperCase());
				scanner.close();

				int vx = v.getX();
				int vy = v.getY();
				Card[][] cards = b.getCards();

				switch (direction) {
				case UP:
					if (vx > 0) {
						System.out.println("Moving u");
						for (int i = vx - 1; i >= 0; i--) {
							if (((CharacterCard) (cards[i][vy])).getHouse() == house) {
								System.out.println("Taking " + cards[i][vy].getName());
								cards[i][vy] = null;
								switch (houseString.toUpperCase()) {
								case "STARK":
									b.setStarkCards(b.getStarkCards() - 1);
									this.starkCards++;
									break;
								case "GREYJOY":
									b.setGreyjoyCards(b.getGreyjoyCards() - 1);
									this.greyjoyCards++;
									break;
								case "LANNISTER":
									b.setLannisterCards(b.getLannisterCards() - 1);
									this.lannisterCards++;
									break;
								case "TARGARYEN":
									b.setTargaryenCards(b.getTargaryenCards() - 1);
									this.targaryenCards++;
									break;
								case "BARATHEON":
									b.setBaratheonCards(b.getBaratheonCards() - 1);
									this.baratheonCards++;
									break;
								case "TYRELL":
									b.setTyrellCards(b.getTyrellCards() - 1);
									this.tyrellCards++;
									break;
								case "TULLY":
									b.setTullyCards(b.getTullyCards() - 1);
									this.tullyCards++;
									break;
								}
							}
						}
					} else {
						System.out.println("Can't move up");
					}
					break;
				case RIGHT:
					if (vy < 5) {
						System.out.println("Moving r");
						for (int i = vy + 1; i <= 5; i++) {
							if (((CharacterCard) (cards[vx][i])).getHouse() == house) {
								System.out.println("Taking " + cards[vx][i].getName());
								cards[vx][i] = null;
								switch (houseString.toUpperCase()) {
								case "STARK":
									b.setStarkCards(b.getStarkCards() - 1);
									this.starkCards++;
									break;
								case "GREYJOY":
									b.setGreyjoyCards(b.getGreyjoyCards() - 1);
									this.greyjoyCards++;
									break;
								case "LANNISTER":
									b.setLannisterCards(b.getLannisterCards() - 1);
									this.lannisterCards++;
									break;
								case "TARGARYEN":
									b.setTargaryenCards(b.getTargaryenCards() - 1);
									this.targaryenCards++;
									break;
								case "BARATHEON":
									b.setBaratheonCards(b.getBaratheonCards() - 1);
									this.baratheonCards++;
									break;
								case "TYRELL":
									b.setTyrellCards(b.getTyrellCards() - 1);
									this.tyrellCards++;
									break;
								case "TULLY":
									b.setTullyCards(b.getTullyCards() - 1);
									this.tullyCards++;
									break;
								}
							}
						}
					} else {
						System.out.println("Can't move right");
					}
					break;
				case DOWN:
					if (vx < 5) {
						System.out.println("Moving d");
						for (int i = vx + 1; i <= 5; i++) {
							if (((CharacterCard) (cards[i][vy])).getHouse() == house) {
								System.out.println("Taking " + cards[i][vy].getName());
								cards[i][vy] = null;
								switch (houseString.toUpperCase()) {
								case "STARK":
									b.setStarkCards(b.getStarkCards() - 1);
									this.starkCards++;
									break;
								case "GREYJOY":
									b.setGreyjoyCards(b.getGreyjoyCards() - 1);
									this.greyjoyCards++;
									break;
								case "LANNISTER":
									b.setLannisterCards(b.getLannisterCards() - 1);
									this.lannisterCards++;
									break;
								case "TARGARYEN":
									b.setTargaryenCards(b.getTargaryenCards() - 1);
									this.targaryenCards++;
									break;
								case "BARATHEON":
									b.setBaratheonCards(b.getBaratheonCards() - 1);
									this.baratheonCards++;
									break;
								case "TYRELL":
									b.setTyrellCards(b.getTyrellCards() - 1);
									this.tyrellCards++;
									break;
								case "TULLY":
									b.setTullyCards(b.getTullyCards() - 1);
									this.tullyCards++;
									break;
								}
							}
						}
					} else {
						System.out.println("Can't move down");
					}
					break;
				case LEFT:
					if (vy > 0) {
						System.out.println("Moving l");
						for (int i = vy - 1; i >= 0; i--) {
							if (((CharacterCard) (cards[vx][i])).getHouse() == house) {
								System.out.println("Taking " + cards[vx][i].getName());
								cards[vx][i] = null;
								switch (houseString.toUpperCase()) {
								case "STARK":
									b.setStarkCards(b.getStarkCards() - 1);
									this.starkCards++;
									break;
								case "GREYJOY":
									b.setGreyjoyCards(b.getGreyjoyCards() - 1);
									this.greyjoyCards++;
									break;
								case "LANNISTER":
									b.setLannisterCards(b.getLannisterCards() - 1);
									this.lannisterCards++;
									break;
								case "TARGARYEN":
									b.setTargaryenCards(b.getTargaryenCards() - 1);
									this.targaryenCards++;
									break;
								case "BARATHEON":
									b.setBaratheonCards(b.getBaratheonCards() - 1);
									this.baratheonCards++;
									break;
								case "TYRELL":
									b.setTyrellCards(b.getTyrellCards() - 1);
									this.tyrellCards++;
									break;
								case "TULLY":
									b.setTullyCards(b.getTullyCards() - 1);
									this.tullyCards++;
									break;
								}
							}
						}
					} else {
						System.out.println("Can't move left");
					}
					break;
				default:
					System.out.println("That is not a valid direction, please pick between UP, RIGHT, DOWN, LEFT.");
				}
			} catch (IllegalArgumentException e) {
				// e.printStackTrace();
				System.out.println(direction + " is not a valid direction, please pick between UP, RIGHT, DOWN, LEFT.");
				direction = null;
			}
		}

		// 5. update sizes (player + board)
		// 6. check if player needs to get sth (banner/companion card) / lose sth
		// 7. check if player uses sth (???)

		// show curr board after taking
		Main.printBoard(b);
		
		System.out.println();
		printEachDeckCards();
		
	}

	private void printEachDeckCards() {
		System.out.println("Stark cards of player " + number + ": " + starkCards);
		System.out.println("Greyjoy cards of player " + number + ": " + greyjoyCards);
		System.out.println("Lannister cards of player " + number + ": " + lannisterCards);
		System.out.println("Targaryen cards of player " + number + ": " + targaryenCards);
		System.out.println("Baratheon cards of player " + number + ": " + baratheonCards);
		System.out.println("Tyrell cards of player " + number + ": " + tyrellCards);
		System.out.println("Tully cards of player " + number + ": " + tullyCards);
	}
}
