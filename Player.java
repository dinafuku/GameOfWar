/*
Dylan Inafuku
2375529
dinafuku@chapman.edu
CPSC 231-02
MP3: Modern War(fare)
*/
import java.util.*;

public class Player
{
  // Instance variables
  int playerNumber;
  LinkedList<Card> ownedCards;
  // Default constructor
  public Player()
  {
    playerNumber = 0;
    ownedCards = new LinkedList<Card>();
  }
  // Overloaded constructor
  public Player(int playerNumber)
  {
    this.playerNumber = playerNumber;
    ownedCards = new LinkedList<Card>();
  }
  // Accessors
  public int getPlayerNumber()
  {
    return playerNumber;
  }
  public LinkedList<Card> getPlayerDeck()
  {
    return ownedCards;
  }
  // Mutators
  public void setPlayerNumber(int playerNumber)
  {
    this.playerNumber = playerNumber;
  }
  public void setPlayerDeck(LinkedList<Card> ownedCards)
  {
    this.ownedCards = ownedCards;
  }
  // removes/returns one card at the front of the linkedlist/player cards
  public Card flip()
  {
    return ownedCards.remove(0);
  }
  // adds a collection of cards to a list of owned cards
  public void collect(LinkedList<Card> add)
  {
    Random random = new Random();
    while (0 < add.size())
    {
      int index = random.nextInt(add.size());
      ownedCards.addLast(add.remove(index));
    }
  }
  // return true/false based on if a player has won the game (has 52 cards)
  public boolean hasWon()
  {
    if (ownedCards.size() == 52)
    {
      return true;
    }
    return false;
  }
  /* When a battle occurs, a player flips a certain amount of cards based on
    the size of their hand
    */
  public LinkedList<Card> war()
  {
    LinkedList<Card> boardCards = new LinkedList<Card>();
    if (ownedCards.size() >= 3)
    {
      Card one = flip();
      Card two = flip();
      Card three = flip();
      boardCards.add(one);
      boardCards.add(two);
      boardCards.add(three);
    }
    else if (ownedCards.size() >= 2)
    {
      Card one = flip();
      Card two = flip();
      boardCards.add(one);
      boardCards.add(two);
    }
    else if (ownedCards.size() >= 1)
    {
      Card one = flip();
      boardCards.add(one);
    }
    return boardCards;
  }
}
