package tophand;



import org.apache.commons.lang3.StringUtils;;

public class Hand {

	private boolean rflush=false;
	private boolean sflush=false;
	private boolean quads=false;
	private boolean fhouse=false;
	private boolean flush=false;
	private boolean straight=false;
	private boolean trips=false;
	private boolean twopair=false;
	private boolean pair=false;
	private boolean high=false;
	int numpairs=0;
	
	private Card[] hand = new Card[5]; // array of Card objects
	// private Card[] deck; // array of Card objects
	public String faces = "";
	private String suits = "";
	private String[] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
			"T", "J", "Q", "K"};
	private String[] cardSuit = {"C", "D", "H", "S"};

	// Hand constructor (uses deck object)
	public Hand(DeckOfCards deck) {

		// shuffle the deck 10 times
//		for (int i = 0; i < 10; i++) {
//			deck.shuffle();
//		}

		// deal the hand, store in hand object
		for (int i = 0; i < hand.length; i++) {
			hand[i] = deck.dealCard();
		}

		System.out.print(hand[0].toString() + " ");
		System.out.print(hand[1].toString() + " ");
		System.out.print(hand[2].toString() + " ");
		System.out.print(hand[3].toString() + " ");
		System.out.print(hand[4].toString() + " ");;
	}

	public String getSuits() {
		for (int i = 0; i < hand.length; i++) {
			suits = suits + hand[i].toString().substring(1, 2);
		}
		return suits;
	}

	public String getFaces() {
		for (int i = 0; i < hand.length; i++) {
			faces = faces + hand[i].toString().substring(0, 1);
		}
		return faces;
	}

//	public void isFlush(String cards) {
//		int count = 0;
//		for (int i = 0; i < 4; i++) {
//			count = StringUtils.countMatches(cards, cardsuit[i]);
//			if (count == 5) {
//				getFlush();
//			}
//		}
//	}

//	public boolean isStraight(String cards) {
//		boolean answer = true;
//		for (int i = 0; i < cards.length() - 2; i++) {
//			if (!cards.substring(i, i + 1)
//					.equals(cards.substring(i + 1, i + 2))) {
//				answer = false;
//			}
//		}
//		return answer;
//	}
	public void isofaKind(String cards) {

		int count[] = new int[13];

		int i = 0;
		for (String value : cardFace) {

			count[i] = StringUtils.countMatches(cards, value);
//			System.out.println(cards + " " + value + " " + count[i]);
			i++;
		}

		for (i = 0; i < 13; i++) {
			if (count[i] == 4) {
//				System.out.println("matches:"+ + count[i]+ cardFace[i]);
				setQuads(true);
			}
			if (count[i] == 3) {
//				System.out.println("matches:"+ + count[i]+ cardFace[i]);
				setTrips(true);
			}
			if (count[i] == 2) {
//				System.out.println("matches:"+ + count[i]+ cardFace[i]);
				setPair(true);
				numpairs++;
			}
			if (count[i] == 1) {
//				System.out.println("matches:"+ + count[i]+ cardFace[i]);
				setHigh(true);
			}

		}
		if (numpairs==2) {
			setTwoPair(true);
		}

	}

	public String isRoyalFlush(String suits, String faces) {
		return "Royal Flush";
	}
	public String isStraightFlush(String suits, String faces) {
		return "Straight Flush";
	}
	public String isQuads(String faces) {
		return "Quads";
	}
	public String isFullHouse(String faces) {
		return "Full House";
	}
	public String isFlush(String suits) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count = StringUtils.countMatches(suits, cardSuit[i]);
			if (count == 5) {
				return "Flush";
			}				

		}
		return "No Flush";
	}
//	public String isStraight(String faces) {
//		return "Straight";
//	}
//	public String isTrips(String faces) {
//		return "Trips";
//	}
//	public String isTwoPair(String faces) {
//		return "Two Pair";
//	}
//	public String isPair(String faces) {
//		return "Pair";
//	}
//	public String isHigh(String faces) {
//		return "High Card";
//	}

	public boolean getRflush() {
		return rflush;
	}

	public void setRflush(boolean rflush) {
		this.rflush = rflush;
	}

	public boolean getSflush() {
		return sflush;
	}

	public void setSflush(boolean sflush) {
		this.sflush = sflush;
	}

	public boolean getQuads() {
		return quads;
	}

	public void setQuads(boolean quads) {
		this.quads = quads;
	}

	public boolean getFhouse() {
		return fhouse;
	}

	public void setFhouse(boolean fhouse) {
		this.fhouse = fhouse;
	}

	public boolean getFlush() {
		return flush;
	}

	public void setFlush(boolean flush) {
		this.flush = flush;
	}

	public boolean getStraight() {
		return straight;
	}

	public void setStraight(boolean straight) {
		this.straight = straight;
	}

	public boolean getTrips() {
		return trips;
	}

	public void setTrips(boolean trips) {
		this.trips = trips;
	}

	public boolean getTwoPair() {
		return twopair;
	}

	public void setTwoPair(boolean twopair) {
		this.twopair = twopair;
	}

	public boolean getPair() {
		return pair;
	}

	public void setPair(boolean pair) {
		this.pair = pair;
	}
	
	public boolean getHigh() {
		return high;
	}

	public void setHigh(boolean high) {
		this.high = high;
	}

}
