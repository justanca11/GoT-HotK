package game;

import java.util.ArrayList;
import java.util.Collections;

import components.elements.House;
import components.elements.banners.BannerToken;
import components.elements.board.Board;
import components.elements.cards.Card;
import components.elements.cards.CharacterCard;
import components.elements.cards.VarysCard;
import components.elements.decks.HouseDeck;

public class Main {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		System.out.println("Game starting...");

		System.out.println("Game set up...");

		createGameComponents();

		long endTime = System.nanoTime();
		System.out.println("\n\nGame set up took " + (endTime - startTime) / 1_000_000_000.0 + " seconds.");
	}

	// TODO: remove prints when done testing
	private static void createGameComponents() {
		ArrayList<HouseDeck> hd = createHouseDecks();
		VarysCard vc = createVarysCard();
		ArrayList<BannerToken> bt = createBannerTokens();
		Board b = createBoard();
		ArrayList<Card> c = shuffleCards(createCharacterCards(), vc);
		b = populateBoard(b, c);
		
		printHouseDecks(hd);
		printVarysCard(vc);
		printBannerTokens(bt);
		printBoard(b);
	}

	static ArrayList<CharacterCard> createCharacterCards() {

		ArrayList<CharacterCard> allCharacterCards = new ArrayList<CharacterCard>(35);

		// 8 Stark cards
		allCharacterCards.add(new CharacterCard(House.STARK, "Arya"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Bran"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Carlyn"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Eddard"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Lyanna"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Rickon"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Robb"));
		allCharacterCards.add(new CharacterCard(House.STARK, "Sansa"));

		// 7 Greyjoy cards
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Aeron"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Asha"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Balon"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Euron"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Rodrik"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Theon"));
		allCharacterCards.add(new CharacterCard(House.GREYJOY, "Victarion"));

		// 6 Lannister cards
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Cersei"));
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Jaime"));
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Joffrey"));
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Kevan"));
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Tyrion"));
		allCharacterCards.add(new CharacterCard(House.LANNISTER, "Tywin"));

		// 5 Targaryen cards
		allCharacterCards.add(new CharacterCard(House.TARGARYEN, "Aegon 1"));
		allCharacterCards.add(new CharacterCard(House.TARGARYEN, "Aerys"));
		allCharacterCards.add(new CharacterCard(House.TARGARYEN, "Daenerys"));
		allCharacterCards.add(new CharacterCard(House.TARGARYEN, "Aegon 1"));
		allCharacterCards.add(new CharacterCard(House.TARGARYEN, "Viserys"));

		// 4 Baratheon cards
		allCharacterCards.add(new CharacterCard(House.BARATHEON, "Renly"));
		allCharacterCards.add(new CharacterCard(House.BARATHEON, "Shireen"));
		allCharacterCards.add(new CharacterCard(House.BARATHEON, "Stannis"));
		allCharacterCards.add(new CharacterCard(House.BARATHEON, "Robert"));

		// 3 Tyrell cards
		allCharacterCards.add(new CharacterCard(House.TYRELL, "Garlan"));
		allCharacterCards.add(new CharacterCard(House.TYRELL, "Margaery"));
		allCharacterCards.add(new CharacterCard(House.TYRELL, "Olenna"));

		// 2 Tully cards
		allCharacterCards.add(new CharacterCard(House.TULLY, "Edmure"));
		allCharacterCards.add(new CharacterCard(House.TULLY, "Hoster"));

		return allCharacterCards;
	}

	static ArrayList<HouseDeck> createHouseDecks() {
		HouseDeck stark = new HouseDeck(House.STARK, 7);
		HouseDeck greyjoy = new HouseDeck(House.GREYJOY, 6);
		HouseDeck lannister = new HouseDeck(House.LANNISTER, 5);
		HouseDeck targaryen = new HouseDeck(House.TARGARYEN, 4);
		HouseDeck baratheon = new HouseDeck(House.BARATHEON, 3);
		HouseDeck tyrell = new HouseDeck(House.TYRELL, 2);
		HouseDeck tully = new HouseDeck(House.TULLY, 1);

		ArrayList<HouseDeck> houseDecks = new ArrayList<HouseDeck>(7);
		houseDecks.add(stark);
		houseDecks.add(greyjoy);
		houseDecks.add(lannister);
		houseDecks.add(targaryen);
		houseDecks.add(baratheon);
		houseDecks.add(tyrell);
		houseDecks.add(tully);

		ArrayList<CharacterCard> allCharacterCards = createCharacterCards();

		for (CharacterCard cc : allCharacterCards) {
			if (cc.getHouse() == House.STARK) {
				stark.getCards().add(cc);
			} else if (cc.getHouse() == House.GREYJOY) {
				greyjoy.getCards().add(cc);
			} else if (cc.getHouse() == House.LANNISTER) {
				lannister.getCards().add(cc);
			} else if (cc.getHouse() == House.TARGARYEN) {
				targaryen.getCards().add(cc);
			} else if (cc.getHouse() == House.BARATHEON) {
				baratheon.getCards().add(cc);
			} else if (cc.getHouse() == House.TYRELL) {
				tyrell.getCards().add(cc);
			} else if (cc.getHouse() == House.TULLY) {
				tully.getCards().add(cc);
			}
		}

		return houseDecks;
	}

	private static void printHouseDecks(ArrayList<HouseDeck> houseDecks) {
		System.out.println("\nHouse decks:");
		for (HouseDeck hd : houseDecks) {
			System.out.println(hd);
		}
	}

	static VarysCard createVarysCard() {
		return new VarysCard("Varys");
	}

	private static void printVarysCard(VarysCard vc) {
		System.out.println("\nVarys:");
		System.out.println(vc);
	}

	static ArrayList<BannerToken> createBannerTokens() {
		ArrayList<BannerToken> banners = new ArrayList<BannerToken>(House.values().length);
		for (House h : House.values()) {
			banners.add(new BannerToken(h));
		}
		return banners;
	}

	private static void printBannerTokens(ArrayList<BannerToken> bannerTokens) {
		System.out.println("\nBanner tokens:");
		for (BannerToken bt : bannerTokens) {
			System.out.println(bt);
		}
	}

	public static Board createBoard() {
		return new Board(6, 6);
	}

	public static Board populateBoard(Board b, ArrayList<Card> allCards) {
		Card[][] temp = new Card[6][6];
		for (int i = 0; i < allCards.size(); i++) {
			temp[allCards.get(i).getX()][allCards.get(i).getY()] = allCards.get(i);
		}
		b.setCards(temp);
		return b;
	}

	private static void printBoard(Board b) {
		System.out.println("\nBoard info:");
		System.out.println(b);
		for (int i = 0; i < b.getRows(); i++) {	
			for (int j = 0; j < b.getColumns(); j++) {
				System.out.print(b.getCards()[i][j].getName() + " | ");
			}
			System.out.println();
		}
	}

	// TODO: improve
	static ArrayList<Card> shuffleCards(ArrayList<CharacterCard> cc, VarysCard vc) {
		ArrayList<Card> allCards = new ArrayList<Card>(36);
		allCards.addAll(cc);
		allCards.add(vc);
		Collections.shuffle(allCards);
		int row = 0;
		int col = 0;
		for (int i = 0; i < allCards.size(); i++) {
			allCards.get(i).setX(row);
			allCards.get(i).setY(col);
			col++;
			if (col == 6) {
				col = 0;
				row++;
			}
		}
		return allCards;
	}

}
