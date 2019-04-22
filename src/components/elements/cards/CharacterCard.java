package components.elements.cards;

import java.util.ArrayList;

import components.elements.House;
import components.elements.behaviour.Arrangeable;

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
		return super.getName() + " " + house.toString() + " is at position " + "(" + getX() + "," + getY() + ")";
	}
	
	
}
