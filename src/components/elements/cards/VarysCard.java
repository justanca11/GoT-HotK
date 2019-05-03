package components.elements.cards;

import components.elements.House;
import components.elements.behaviour.Movable;
import components.elements.board.Board;
import components.player.Player;
import components.player.Player.Direction;

public class VarysCard extends Card implements Movable {

	public VarysCard(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return super.getName() + " is at position " + "(" + getX() + "," + getY() + ").";
	}

	public boolean isLegalMove(Direction direction, int cellNo, Card[][] boardCards, House house) {
		switch (direction) {
		case UP:
			if (this.getX() > 0 && boardCards[cellNo][this.getY()] != null
					&& ((CharacterCard) (boardCards[cellNo][this.getY()])).getHouse() == house) {
				System.out.println("Moving up holder.");
			} else {
				System.out.println("Illegal move, please retry.");
				return false;
			}
			break;
		case RIGHT:
			if (this.getY() < 5 && boardCards[this.getX()][cellNo] != null
					&& ((CharacterCard) (boardCards[this.getX()][cellNo])).getHouse() == house) {
				System.out.println("Moving right holder.");
			} else {
				System.out.println("Illegal move, please retry.");
				return false;
			}
			break;
		case DOWN:
			if (this.getX() < 5 && boardCards[cellNo][this.getY()] != null
					&& ((CharacterCard) (boardCards[cellNo][this.getY()])).getHouse() == house) {
				System.out.println("Moving down holder.");
			} else {
				System.out.println("Illegal move, please retry.");
				return false;
			}
			break;
		case LEFT:
			if (this.getY() > 0 && boardCards[this.getX()][cellNo] != null
					&& ((CharacterCard) (boardCards[this.getX()][cellNo])).getHouse() == house) {
				System.out.println("Moving left holder.");
			} else {
				System.out.println("Illegal move, please retry.");
				return false;
			}
			break;
		default:
			// never reached
			System.out.println("Illegal move, please retry.");
			return false;
		}
		return true;
	}

	public void move(Direction direction, int cellNo, Card[][] boardCards, House house, Player player, Board board) {
		switch (direction) {
		case UP:
			for (int i = this.getX() - 1; i >= cellNo; i--) {
				if (boardCards[i][this.getY()] != null
						&& ((CharacterCard) (boardCards[i][this.getY()])).getHouse() == house) {
					System.out.println("Taking " + boardCards[i][this.getY()].getName());
					boardCards[i][this.getY()] = null;
					this.setX(0);
					player.updateHouseDecksSizes(house.toString());
					board.updateHouseDecksSizes(house.toString());
				}
			}
			// Really moves Varys
			this.setX(cellNo);
			boardCards[cellNo][this.getY()] = this;
			boardCards[this.getX()][this.getY()] = null;
			break;
		case RIGHT:

			for (int i = this.getY() + 1; i <= cellNo; i++) {
				if (boardCards[this.getX()][i] != null && ((CharacterCard) (boardCards[this.getX()][i])).getHouse() == house) {
					System.out.println("Taking " + boardCards[this.getX()][i].getName());
					boardCards[this.getX()][i] = null;
					this.setY(5);
					player.updateHouseDecksSizes(house.toString());
					board.updateHouseDecksSizes(house.toString());
				}
			}
			// Really moves Varys
			this.setY(cellNo);
			boardCards[this.getX()][cellNo] = this;
			boardCards[this.getX()][this.getY()] = null;

			break;
		case DOWN:

			for (int i = this.getX() + 1; i <= cellNo; i++) {
				if (boardCards[i][this.getY()] != null && ((CharacterCard) (boardCards[i][this.getY()])).getHouse() == house) {
					System.out.println("Taking " + boardCards[i][this.getY()].getName());
					boardCards[i][this.getY()] = null;
					this.setX(5);
					player.updateHouseDecksSizes(house.toString());
					board.updateHouseDecksSizes(house.toString());
				}
			}
			// Really moves Varys
			this.setX(cellNo);
			boardCards[cellNo][this.getY()] = this;
			boardCards[this.getX()][this.getY()] = null;

			break;
		case LEFT:

			for (int i = this.getY() - 1; i >= cellNo; i--) {
				if (boardCards[this.getX()][i] != null && ((CharacterCard) (boardCards[this.getX()][i])).getHouse() == house) {
					System.out.println("Taking " + boardCards[this.getX()][i].getName());
					boardCards[this.getX()][i] = null;
					this.setY(0);
					player.updateHouseDecksSizes(house.toString());
					board.updateHouseDecksSizes(house.toString());
				}
			}
			// Really moves Varys
			this.setY(cellNo);
			boardCards[this.getX()][cellNo] = this;
			boardCards[this.getX()][this.getY()] = null;

			break;
		default:
			System.out.println("That is not a valid direction, please pick between UP, RIGHT, DOWN, LEFT.");
		}
	}
}
