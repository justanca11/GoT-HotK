package components.elements.cards;

import components.behaviour.Movable;
import components.elements.board.Board;
import components.player.Player;
import util.enums.Direction;
import util.enums.House;

public class VarysCard extends Card implements Movable {

	public VarysCard(String name) {
		super(name);
	}

	@Override
	public boolean isLegalMove(Direction direction, int cellNo, Card[][] boardCards, House house) {
		switch (direction) {
		case UP:
			if (this.getX() <= 0 || boardCards[cellNo][this.getY()] == null
					|| ((CharacterCard) (boardCards[cellNo][this.getY()])).getHouse() != house) {
				return false;
			}
			break;
		case RIGHT:
			if (this.getY() >= 5 || boardCards[this.getX()][cellNo] == null
					|| ((CharacterCard) (boardCards[this.getX()][cellNo])).getHouse() != house) {
				return false;
			}
			break;
		case DOWN:
			if (this.getX() >= 5 || boardCards[cellNo][this.getY()] == null
					|| ((CharacterCard) (boardCards[cellNo][this.getY()])).getHouse() != house) {
				return false;
			}
			break;
		case LEFT:
			if (this.getY() <= 0 || boardCards[this.getX()][cellNo] == null
					|| ((CharacterCard) (boardCards[this.getX()][cellNo])).getHouse() != house) {
				return false;
			}
			break;
		default:
			// never reached
			return false;
		}
		return true;
	}

	@Override
	public void move(Player player, Direction direction, int cellNo, Board board, House house) {
		Card[][] boardCards = board.getCards();

		// empties Varys start position
		boardCards[this.getX()][this.getY()] = null;

		switch (direction) {
		case UP:
			// for all cards between Varys start and end coordinate
			for (int i = this.getX() - 1; i >= cellNo; i--) {
				// checks if the is of the chosen house
				if (boardCards[i][this.getY()] != null
						&& ((CharacterCard) (boardCards[i][this.getY()])).getHouse() == house) {
					// if it is then it's removed from there TODO: move it to player pile, for now
					// just remove
					boardCards[i][this.getY()] = null;
					// update chosen house deck size for the player who moved Varys
					player.updateHouseDeckSize(house);
					// update chosen house deck size for the board
					board.updateHouseDeckSize(house);
				}
			}
			// updates Varys X to input stop X
			this.setX(cellNo);
			break;
		case RIGHT:
			for (int i = this.getY() + 1; i <= cellNo; i++) {
				if (boardCards[this.getX()][i] != null
						&& ((CharacterCard) (boardCards[this.getX()][i])).getHouse() == house) {
					boardCards[this.getX()][i] = null;
					player.updateHouseDeckSize(house);
					board.updateHouseDeckSize(house);
				}
			}
			// updates Varys Y to input stop Y
			this.setY(cellNo);
			break;
		case DOWN:
			for (int i = this.getX() + 1; i <= cellNo; i++) {
				if (boardCards[i][this.getY()] != null
						&& ((CharacterCard) (boardCards[i][this.getY()])).getHouse() == house) {
					boardCards[i][this.getY()] = null;
					player.updateHouseDeckSize(house);
					board.updateHouseDeckSize(house);
				}
			}
			this.setX(cellNo);
			break;
		case LEFT:
			for (int i = this.getY() - 1; i >= cellNo; i--) {
				if (boardCards[this.getX()][i] != null
						&& ((CharacterCard) (boardCards[this.getX()][i])).getHouse() == house) {
					boardCards[this.getX()][i] = null;
					player.updateHouseDeckSize(house);
					board.updateHouseDeckSize(house);
				}
			}
			this.setY(cellNo);
			break;
		default:
			// not reached
			System.out.println(
					"That is not a valid direction, please pick between UP, RIGHT, DOWN and LEFT (not case sensitive).");
		}

		// actually moves Varys to the new position
		boardCards[this.getX()][this.getY()] = this;
	}

	@Override
	public String toString() {
		return super.getName() + " is at position " + "(" + getX() + "," + getY() + ").";
	}

}
