package components.elements.cards;

public class Card {
	private String name;
	
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card(String name) {
		super();
		this.name = name;
	}
	
	public Card() {
		super();
	}

	@Override
	public String toString() {
		return name;
	}
}
