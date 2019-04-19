package components.elements.cards;

import components.elements.behaviour.Movable;

public class VarysCard extends Card implements Movable {
	private int x;
	private int y;

	public VarysCard(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return super.getName() + " is at position " + "(" + x + "," + y + ").";
	}
}
