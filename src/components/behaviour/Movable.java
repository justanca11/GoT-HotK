package components.behaviour;

import components.elements.board.Board;
import components.elements.cards.Card;
import components.player.Player;
import util.Direction;
import util.House;

public interface Movable {
	boolean isMovable(Card[][] boardCards);
	boolean isLegalMove(Direction direction, int cellNo, Card[][] boardCards, House house);
	void move(Player player, Direction direction, int cellNo, Board board, House house);
}
