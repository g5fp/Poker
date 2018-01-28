package tophand;

import java.util.Arrays;

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

	private Card[] hand = new Card[5]; // array of Card objects

	public String faces = "";
	private String suits = "";
	private String[] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
			"T", "J", "Q", "K"};
	private String[] cardSuit = {"C", "D", "H", "S"};

	// Hand constructor (uses deck object)
	public Hand(DeckOfCards deck) {

		// deal the hand, store in hand object
		for (int i = 0; i < hand.length; i++) {
			hand[i] = deck.dealCard();
		}
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

	public void isRFlush(String faces, String suits) {
		isFlush(suits);
		if (faces.equals("TJQKA") && getFlush()) {
			setRflush(true);
		}
	}

	public void isSFlush(String faces, String suits) {
		isStraight(faces);
		isFlush(suits);
		if (getFlush() && getStraight()) {
			setSflush(true);
		}
	}
	
	public void isStraight(String faces) {

		if (faces.contains("A2345")) {
			setStraight(true);
		}
		if (faces.contains("23456")) {
			setStraight(true);
		}
		if (faces.contains("34567")) {
			setStraight(true);
		}
		if (faces.contains("45678")) {
			setStraight(true);
		}
		if (faces.contains("56789")) {
			setStraight(true);
		}
		if (faces.contains("6789T")) {
			setStraight(true);
		}
		if (faces.contains("789TJ")) {
			setStraight(true);
		}
		if (faces.contains("89TJQ")) {
			setStraight(true);
		}
		if (faces.contains("9TJQK")) {
			setStraight(true);
		}
		if (faces.contains("TJQKA")) {
			setStraight(true);
		}
	}
	
	public void isofaKind(String cards) {

		int count[] = new int[13];
		int i = 0;
		int numpairs=0;

		for (String value : cardFace) {
			count[i] = StringUtils.countMatches(cards, value);
			i++;
		}

		for (i = 0; i < 13; i++) {
			if (count[i] == 4) {
				setQuads(true);
			}
			if (count[i] == 3) {
				setTrips(true);
			}
			if (count[i] == 2) {
				setPair(true);
				numpairs++;
			}
			if (count[i] == 1) {
				setHigh(true);
			}
		}

		if (numpairs==2) {
			setTwoPair(true);
		}
		if (getTrips() && getPair()) {
			setFhouse(true);
		}
	}

	public void isFlush(String suits) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count = StringUtils.countMatches(suits, cardSuit[i]);
			if (count == 5) {
				setFlush(true);
			}				
		}
	}

	public String sortAhigh(String faces) {
		faces = faces.replaceAll("T", "B");
		faces = faces.replaceAll("J", "C");
		faces = faces.replaceAll("Q", "D");
		faces = faces.replaceAll("K", "E");
		faces = faces.replaceAll("A", "F");

		char[] myFaces = new char[5];
		myFaces = faces.toCharArray();
		Arrays.sort(myFaces);
		String sortedfaceshigh="";
		for (int i = 0; i < myFaces.length; i++) {
			sortedfaceshigh = new String(myFaces);
		}

		
		sortedfaceshigh = sortedfaceshigh.replaceAll("B", "T");
		sortedfaceshigh = sortedfaceshigh.replaceAll("C", "J");
		sortedfaceshigh = sortedfaceshigh.replaceAll("D", "Q");
		sortedfaceshigh = sortedfaceshigh.replaceAll("E", "K");
		sortedfaceshigh = sortedfaceshigh.replaceAll("F", "A");
//		System.out.println("myfaces="+sortedfaceshigh);
		faces=sortedfaceshigh;
		return 	sortedfaceshigh;	
	}
	
	public String sortAlow(String faces) {
		faces = faces.replaceAll("A", "1");
		faces = faces.replaceAll("T", "B");
		faces = faces.replaceAll("J", "C");
		faces = faces.replaceAll("Q", "D");
		faces = faces.replaceAll("K", "E");


		char[] myFaces = new char[5];
		myFaces = faces.toCharArray();
		Arrays.sort(myFaces);
		String sortedfaceslow="";
		for (int i = 0; i < myFaces.length; i++) {
			sortedfaceslow = new String(myFaces);
		}

		
		sortedfaceslow = sortedfaceslow.replaceAll("B", "T");
		sortedfaceslow = sortedfaceslow.replaceAll("C", "J");
		sortedfaceslow = sortedfaceslow.replaceAll("D", "Q");
		sortedfaceslow = sortedfaceslow.replaceAll("E", "K");
		sortedfaceslow = sortedfaceslow.replaceAll("1", "A");
//		System.out.println("myfaces="+sortedfaceslow);
		return 	sortedfaceslow;	
	}
	
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
