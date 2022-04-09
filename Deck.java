/*
Dylan Inafuku
2375529
dinafuku@chapman.edu
CPSC 231-02
MP3: Modern War(fare)
*/
import java.util.*;

public class Deck
{
  // Instance variables
  LinkedList<Card> deck;

  // Random object
  Random random = new Random();
  //Default constructor
  public Deck()
  {
    deck = new LinkedList<Card>();
    createDeck();
  }
  // Accessors
  public LinkedList<Card> getDeck()
  {
    return deck;
  }
  // Mutators
  public void setDeck(LinkedList<Card> deck)
  {
    this.deck = deck;
  }
  /* creates a new deck of 52 cards, values 2-14 with C,D,H,S
    (clubs, diamonds, hearts, spades)
    */
  private void createDeck()
  {
    for (int i = 2; i <= 14; i++)
    {
      deck.add(new Card(i, "C"));
      deck.add(new Card(i, "D"));
      deck.add(new Card(i, "H"));
      deck.add(new Card(i, "S"));
    }
  }
  // returns one random card from the deck
  public Card deal()
  {
    int index = random.nextInt(deck.size());
    return deck.remove(index);
  }
}
