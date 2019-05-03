package components.behaviour;

import components.elements.board.Board;
import components.elements.cards.Card;
import components.player.Player;
import util.enums.Direction;
import util.enums.House;

public interface Movable {
	boolean isLegalMove(Direction direction, int cellNo, Card[][] boardCards, House house);
	void move(Player player, Direction direction, int cellNo, Board board, House house);
}
