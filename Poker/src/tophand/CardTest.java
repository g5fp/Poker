package tophand;

public class CardTest {

	public static void main(String[] args) {

		String faces ="";
		String suits="";
		Boolean result=false;
//		for (int i = 0; i < 10; i++) {
//			myDeckOfCards.shuffle();
//		}
		
		DeckOfCards myDeckOfCards = new DeckOfCards();
		Hand myHand = new Hand(myDeckOfCards);
		suits = myHand.getSuits();
		faces=myHand.getFaces();
		System.out.println();
		System.out.println("Suits:"+suits+ " Faces:"+faces);
		faces="2Q2KK";
		myHand.isFlush(suits);
		myHand.isofaKind(faces);
//		System.out.println("Royal Flush:"+ myHand.getRflush());
//		System.out.println("Straight Flush:"+ myHand.getSflush());		
//		System.out.println("Quads:" + myHand.getQuads());
//		System.out.println("Full House:"+ myHand.getFhouse());
//		System.out.println("Flush:"+ myHand.getFlush());
//		System.out.println("Straight:"+ myHand.getStraight());
//		System.out.println("Trips:" + myHand.getTrips());
//		System.out.println("Two Pair:"+myHand.getTwoPair());
//		System.out.println("Pair:" + myHand.getPair());
//		System.out.println("High:" + myHand.getHigh());

		do {
			result =myHand.getRflush();
			if (result) {
				System.out.println("High Hand is: Royal Flush:");
			}
			if (result) {
				System.out.println("High Hand is: Straight Flush:");
			}
			result=myHand.getQuads();
			if (result) {
				System.out.println("High Hand is: Quads:");
			}
			result=myHand.getTrips();
			if (result) {
				System.out.println("High Hand is: Trips:");
			}
			result=myHand.getTwoPair();
			if (result) {
				System.out.println("High Hand is: Two Pair:");
			}
			result=myHand.getPair();
			if (result) {
				System.out.println("High Hand is: Pair:");
			}
		} while (result=false);
		
//		System.out.println(myHand.isPair(faces));
//		System.out.println(myHand.isTrips(faces));
//		System.out.println(myHand.isQuads(faces));
		
	}

}
