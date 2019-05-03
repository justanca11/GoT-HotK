package components.player;

import java.util.Scanner;

import app.Main;
import components.elements.board.Board;
import components.elements.cards.VarysCard;
import interaction.ConsoleInteraction;
import util.enums.Direction;
import util.enums.House;

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

	static Scanner scanner = new Scanner(System.in);

	public void doTurn(Board b) {
		// show curr board
		Main.printBoard(b);
		VarysCard v = b.getVarys();

		System.out.println("\n" + v);

		// 1.1. choose house
		House house = ConsoleInteraction.promptChooseHouse(scanner);
		// 1.2. choose direction
		Direction direction = ConsoleInteraction.promptChooseDirection(scanner);
		// 1.3 choose stop cell
		int cellNo = ConsoleInteraction.promptChooseStopCell(scanner);

		// 2. check if move is legal
		if (v.isLegalMove(direction, cellNo, b.getCards(), house)) {
			System.out.println("Legal move");
			// 3. move varys and grab the cards and update the deck sizes
			v.move(this, direction, cellNo, b, house);
			// 6. check if player needs to get sth (banner/companion) / lose sth
			// 7. check if player uses sth (???)
		} else {
			System.out.println("Illegal move, please retry.");
		}

		// show curr board after grab
		// Main.printBoard(b);

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

	public void updateHouseDeckSize(House house) {
		switch (house) {
		case STARK:
			this.starkCards++;
			break;
		case GREYJOY:
			this.greyjoyCards++;
			break;
		case LANNISTER:
			this.lannisterCards++;
			break;
		case TARGARYEN:
			this.targaryenCards++;
			break;
		case BARATHEON:
			this.baratheonCards++;
			break;
		case TYRELL:
			this.tyrellCards++;
			break;
		case TULLY:
			this.tullyCards++;
			break;
		default:
			// not reached
			System.out.println(
					"That is not a valid house, please choose between houses Stark, Grejoy, Lannister, Targaryen, Baratheon, Tyrell and Tully (not case sensitive). ");
		}
	}
}
