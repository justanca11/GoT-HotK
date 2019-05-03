package components.elements.banners;

import util.enums.House;

public class BannerToken extends Token {
	private House house;

	public BannerToken(House house) {
		super();
		this.house = house;
	}
	
	@Override
	public String toString() {
		return house.toString() + " banner";
	}
}
