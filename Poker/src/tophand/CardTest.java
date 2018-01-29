package tophand;
//modified from work
public class CardTest {

	public static void main(String[] args) {

		String faces = "";
		String suits = "";
		Boolean result = false;
		int[] handCounts = new int[10];

		// setting the number of hands dealt
		for (int j = 0; j < 1; j++) {
			System.out.println("Hands Dealt:" + (j+1));
			// create a deck of cards object
			DeckOfCards myDeckOfCards = new DeckOfCards();
			
			//shuffle the cards 10 times
			for (int i = 0; i < 10; i++) {
				myDeckOfCards.shuffle();
			}
			// create a hand of cards from myDeckOfCards object
			Hand myHand = new Hand(myDeckOfCards);

			suits = myHand.getSuits();
			faces = myHand.getFaces();
			// uncomment the two line below if you want to test a particular hand
			// also set the loop to only deal 1 hand.
//			faces = "TJQKA";
//			suits = "SSSSS";
			
			//sort the card high to low and low to high
			String sortedCardsHigh = myHand.sortAhigh(faces);
			String sortedCardsLow = myHand.sortAlow(faces);
			
			//check hand rankings
			myHand.isRFlush(sortedCardsHigh, suits);
			myHand.isSFlush(sortedCardsHigh, suits);
			myHand.isofaKind(faces);
			myHand.isFlush(suits);
			myHand.isStraight(sortedCardsLow);
			myHand.isStraight(sortedCardsHigh);

			do {
				result = myHand.getRflush();
				if (result) {
					System.out.println("High Hand is: Royal Flush");
					handCounts[0]++;
					break;
				}
				result = myHand.getSflush();
				if (result) {
					System.out.println("High Hand is: Straight Flush");
					handCounts[1]++;
					break;
				}
				result = myHand.getQuads();
				if (result) {
					System.out.println("High Hand is: Quads");
					handCounts[2]++;
					break;
				}
				result = myHand.getFhouse();
				if (result) {
					System.out.println("High Hand is: Full House");
					handCounts[3]++;
					break;
				}
				result = myHand.getFlush();
				if (result) {
					System.out.println("High Hand is: Flush");
					handCounts[4]++;
					break;
				}
				result = myHand.getStraight();
				if (result) {
					System.out.println("High hand is: Straight");
					handCounts[5]++;
					break;
				}
				result = myHand.getTrips();
				if (result) {
					System.out.println("High Hand is: Trips");
					handCounts[6]++;
					break;
				}
				result = myHand.getTwoPair();
				if (result) {
					System.out.println("High Hand is: Two Pair");
					handCounts[7]++;
					break;
				}
				result = myHand.getPair();
				if (result) {
					System.out.println("High Hand is: Pair");
					handCounts[8]++;
					break;
				}
				result = myHand.getHigh();
				if (result) {
					System.out.println("High Hand is: High Card");
					handCounts[9]++;
					break;
				}

			} while (result);

			// printing the hand.  Combining the suits and faces back together
			for (int i = 0; i < 5; i++) {
				System.out.print(sortedCardsHigh.substring(i, i + 1)
						+ suits.substring(i, i + 1) + " ");
			}
			System.out.println();
		}
		
		System.out.println("Hand Counts:");
		System.out.println("Royal Flush:" + handCounts[0]);
		System.out.println("Straight Flush:" + handCounts[1]);
		System.out.println("Quads:" + handCounts[2]);
		System.out.println("Full House:" + handCounts[3]);
		System.out.println("Flush:" + handCounts[4]);
		System.out.println("Straight:" + handCounts[5]);
		System.out.println("Trips:" + handCounts[6]);
		System.out.println("Two Pair:" + handCounts[7]);
		System.out.println("One Pair:" + handCounts[8]);
		System.out.println("High Card:" + handCounts[9]);
	}
}
