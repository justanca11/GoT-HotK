package app;

public class MainTest {
	/*@Test
	// TODO: refactor into proper unit tests etc
	public void createGameComponents() {
		ArrayList<HouseDeck> hd = Main.createHouseDecks();
		ArrayList<BannerToken> bt = Main.createBannerTokens();

		// Check house decks, banner tokens sizes
		assertEquals(7, hd.size());
		assertEquals(7, bt.size());

		// Check house decks, banner tokens sizes equal to house sizes
		assertEquals(hd.size(), House.values().length);
		assertEquals(bt.size(), House.values().length);

		// Check house decks sizes correct
		for (HouseDeck hdi : hd) {
			if (hdi.getName() == House.STARK) {
				assertEquals(8, hdi.getCards().size());
			} else if (hdi.getName() == House.GREYJOY) {
				assertEquals(7, hdi.getCards().size());
			} else if (hdi.getName() == House.LANNISTER) {
				assertEquals(6, hdi.getCards().size());
			} else if (hdi.getName() == House.TARGARYEN) {
				assertEquals(5, hdi.getCards().size());
			} else if (hdi.getName() == House.BARATHEON) {
				assertEquals(4, hdi.getCards().size());
			} else if (hdi.getName() == House.TYRELL) {
				assertEquals(3, hdi.getCards().size());
			} else if (hdi.getName() == House.TULLY) {
				assertEquals(2, hdi.getCards().size());
			}
		}

		// Check board size
		Board b = Main.createBoard();
		assertEquals(6, b.getRows());
		assertEquals(6, b.getColumns());

		// Check board size and number of character cards + Varys card add up
		assertEquals(b.getRows() * b.getColumns(), Main.createCharacterCards().size() + 1);

		// TODO: Check that the shuffle is a decent shuffle. But the method
		// probably needs improvement anyhow ¯\_(ツ)_/¯
	}*/
}
