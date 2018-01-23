package tophand;

public class CardTest
{
   // execute application
   public static void main(String[] args)
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
//      myDeckOfCards.shuffle(); // place Cards in random order
      
      // print all 52 Cards in the order in which they are dealt
      for (int i = 1; i <= 5; i++)
      {
         // deal and display a Card
         
//         System.out.printf("%-19s", myDeckOfCards.dealCard());

                 if (i % 5 == 0) // output a newline after every fourth card
                    System.out.println();
      } 
      String [] myHand = myDeckOfCards.dealHand();
      for (int i = 0; i < myHand.length; i++)
    {
          System.out.printf("%-19s", myHand[i]);
    }
      System.out.println("Royal Flush:"+myDeckOfCards.checkRFlush(myHand));
      
      
   } 

   

} // end class DeckOfCardsTest

