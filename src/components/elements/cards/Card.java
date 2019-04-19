package components.elements.cards;

public class Card {
	private String name;

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

	@Override
	public String toString() {
		return name;
	}
}
