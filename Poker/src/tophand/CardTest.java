package tophand;

public class CardTest {

	public static void main(String[] args) {

		String faces ="";
		String suits="";
		Boolean result=false;
		int[] handCounts = new int[10];
		
		DeckOfCards myDeckOfCards = new DeckOfCards();

		
		for (int j=0;j<1000000;j++) {		
		
			for (int i = 0; i < 10; i++) {
				myDeckOfCards.shuffle();
			}
			Hand myHand = new Hand(myDeckOfCards);
			suits = myHand.getSuits();
			faces=myHand.getFaces();
	//		faces="23456";
	//		suits="CHHHH";
			myHand.isRFlush(faces, suits);
			myHand.isSFlush(faces, suits);
			myHand.isFlush(suits);
			myHand.isofaKind(faces);
			
			String sortedCardsHigh =myHand.sortAhigh(faces);
			String sortedCardsLow =myHand.sortAlow(faces);
			myHand.isStraight(sortedCardsLow);
			myHand.isStraight(sortedCardsHigh);
			

			do {
				result =myHand.getRflush();
				if (result) {
//					System.out.println("High Hand is: Royal Flush");
					handCounts[0]++;
					break;
				}
				result=myHand.getSflush();
				if (result) {
//					System.out.println("High Hand is: Straight Flush");
					handCounts[1]++;
					break;
				}
				result=myHand.getQuads();
				if (result) {
//					System.out.println("High Hand is: Quads");
					handCounts[2]++;
					break;
				}
				result=myHand.getFhouse();
				if (result) {
//					System.out.println("High Hand is: Full House");
					handCounts[3]++;
					break;
				}
				result=myHand.getFlush();
				if (result) {
//					System.out.println("High Hand is: Flush");
					handCounts[4]++;
					break;
				}
				result=myHand.getStraight();
				if (result) {
//					System.out.println("High hand is: Straight");
					handCounts[5]++;
					break;
				}
				result=myHand.getTrips();
				if (result) {
//					System.out.println("High Hand is: Trips");
					handCounts[6]++;
					break;
				}
				result=myHand.getTwoPair();
				if (result) {
//					System.out.println("High Hand is: Two Pair");
					handCounts[7]++;
					break;
				}
				result=myHand.getPair();
				if (result) {
//					System.out.println("High Hand is: Pair");
					handCounts[8]++;
					break;
				}
//				System.out.println("High Hand is: High Card");
				handCounts[9]++;
			}
			while (result);

			for (int i = 0; i < 5; i++) {
				System.out.print(faces.substring(i, i+1)+suits.substring(i,i+1) + " ");
			}
			System.out.println();

		}
		System.out.println("hand counts:");
		System.out.println("Royal Flush:"+handCounts[0]);
		System.out.println("Straight Flush:"+handCounts[1]);
		System.out.println("Quads:"+handCounts[2]);
		System.out.println("Full House:"+handCounts[3]);
		System.out.println("Flush:"+handCounts[4]);
		System.out.println("Straight:"+handCounts[5]);
		System.out.println("Trips:"+handCounts[6]);
		System.out.println("Two Pair:"+handCounts[7]);
		System.out.println("One Pair:"+handCounts[8]);
		System.out.println("High Card:"+handCounts[9]);
	}
}
