/*
Dylan Inafuku
2375529
dinafuku@chapman.edu
CPSC 231-02
MP3: Modern War(fare)
*/
import java.util.*;

public class Game
{
  // Instance variables
  Player one;
  Player two;
  int gameNumber;
  Deck gameDeck;
  int battles;
  int wars;
  int doubleWars;
  // Default constructor
  public Game()
  {
    one = new Player(1);
    two = new Player(2);
    gameNumber = 0;
    gameDeck = new Deck();
    battles = 0;
    wars = 0;
    doubleWars = 0;
  }
  // Overloaded constructor
  public Game(int gameNumber)
  {
    one = new Player(1);
    two = new Player(2);
    this.gameNumber = gameNumber;
    gameDeck = new Deck();
    battles = 0;
    wars = 0;
    doubleWars = 0;
  }
  //Accessors
  public Player getPlayerOne()
  {
    return one;
  }
  public Player getPlayerTwo()
  {
    return two;
  }
  public int getGameNumber()
  {
    return gameNumber;
  }
  public Deck getGameDeck()
  {
    return gameDeck;
  }
  public int getBattles()
  {
    return battles;
  }
  public int getWars()
  {
    return wars;
  }
  public int getDoubleWars()
  {
    return doubleWars;
  }
  // Mutators
  public void setPlayerOne(Player one)
  {
    this.one = one;
  }
  public void setPlayerTwo(Player two)
  {
    this.two = two;
  }
  public void setGameNumber(int gameNumber)
  {
    this.gameNumber = gameNumber;
  }
  public void setGameDeck(Deck gameDeck)
  {
    this.gameDeck = gameDeck;
  }
  public void setBattles(int battles)
  {
    this.battles = battles;
  }
  public void setWars(int wars)
  {
    this.wars = wars;
  }
  public void setDoubleWars(int doubleWars)
  {
    this.doubleWars = doubleWars;
  }

  // Fill player hands each with 26 cards
  private void dealToPlayers()
  {
    for (int i = 0; i < 26; i++)
    {
      one.ownedCards.add(gameDeck.deal());
      two.ownedCards.add(gameDeck.deal());
    }
  }
  // Calculates the median number of three numbers
  private int calculate(int one, int two, int three)
  {
    if ((one > two && one < three) || (one > three & one < two))
    {
      return one;
    }
    else if ((two > one && two < three) || (two > three & two < one))
    {
      return two;
    }
    else if ((three > two && three < one) || (three > one & three < two))
    {
      return three;
    }
    else if ((one == two && one > three) || (one == three && one > two))
    {
      return one;
    }
    else if (two == three && two > one)
    {
      return two;
    }
    else
    {
      return three;
    }
  }
  // Plays a game between two players
  public void play()
  {
    // Initialize variables
    boolean end = false;
    int medianOne = 0;
    int medianTwo = 0;
    int battleNumber = 1;
    LinkedList<Card> addCardsOne = new LinkedList<Card>();
    LinkedList<Card> addCardsTwo = new LinkedList<Card>();
    // Deal to player hands
    dealToPlayers();
    // While the game isn't over/a player hasn't won
    while (!end)
    {
      // Flips three cards, gets median for player one
      addCardsOne = one.war();
      Card[] h;
      h = new Card[addCardsOne.size()];
      // fills card array with player hand
      for (int i = 0, n = addCardsOne.size(); i < n; i++)
      {
        h[i] = addCardsOne.get(i);
      }
      WarLogger.getInstance().logBattle(battleNumber, WarLogger.P1, h);
      /* Based on the size of the player hand, get the median of those cards
        and calculate the median
        */
      if (addCardsOne.size() >= 3)
      {
        Card one = addCardsOne.get(0);
        Card two = addCardsOne.get(1);
        Card three = addCardsOne.get(2);
        medianOne = calculate(one.getValue(), two.getValue(), three.getValue());
      }
      else if (addCardsOne.size() >= 2)
      {
        Card one = addCardsOne.get(0);
        Card two = addCardsOne.get(1);
        if (one.getValue() > two.getValue())
        {
          medianOne = one.getValue();
        }
        else if (two.getValue() > one.getValue())
        {
          medianOne = two.getValue();
        }
      }
      else if (addCardsOne.size() >= 1)
      {
        Card one = addCardsOne.get(0);
        medianOne = one.getValue();
      }

      // Flips three cards, gets median for player two
      addCardsTwo = two.war();
      Card[] j;
      j = new Card[addCardsTwo.size()];
      // fills card array for player hand
      for (int i = 0, n = addCardsTwo.size(); i < n; i++)
      {
        j[i] = addCardsTwo.get(i);
      }
      WarLogger.getInstance().logBattle(battleNumber, WarLogger.P2, j);
      /* Based on the size of the player hand, get the values of those cards
        and calculate the median
        */
      if (addCardsTwo.size() >= 3)
      {
        Card four = addCardsTwo.get(0);
        Card five = addCardsTwo.get(1);
        Card six = addCardsTwo.get(2);
        medianTwo = calculate(four.getValue(), five.getValue(), six.getValue());
      }
      else if (addCardsTwo.size() >= 2)
      {
        Card four = addCardsTwo.get(0);
        Card five = addCardsTwo.get(1);
        if (four.getValue() > five.getValue())
        {
          medianTwo = four.getValue();
        }
        else if (five.getValue() > four.getValue())
        {
          medianTwo = five.getValue();
        }
      }
      else if (addCardsTwo.size() >= 1)
      {
        Card four = addCardsTwo.get(0);
        medianTwo = four.getValue();
      }
      // Fills a linked list with all cards on the board
      LinkedList<Card> boardCards = new LinkedList<Card>();
      for (int i = 0, n = addCardsOne.size(); i < n; i++)
      {
        boardCards.add(addCardsOne.get(i));
      }
      for (int i = 0, n = addCardsTwo.size(); i < n; i++)
      {
        boardCards.add(addCardsTwo.get(i));
      }
      // Compares medians to determine which player wins (higher median wins)
      if (medianOne > medianTwo)
      {
        one.collect(boardCards);
        WarLogger.getInstance().logBattleOutcome(battleNumber, WarLogger.P1);
      }
      else if (medianTwo > medianOne)
      {
        two.collect(boardCards);
        WarLogger.getInstance().logBattleOutcome(battleNumber, WarLogger.P2);
      }
      else
      {
        // If the medians are the same, run the war method
        String winner = war();
        if (winner.equals("One"))
        {
          one.collect(boardCards);
        }
        else if (winner.equals("Two"))
        {
          two.collect(boardCards);
        }
      }
      // When a battle ends, increment battles
      battles++;
      // Checks to see if anyone has won the game
      if (one.hasWon())
      {
        WarLogger.getInstance().logGameOutcome(gameNumber, WarLogger.P1);
        end = true;
      }
      else if (two.hasWon())
      {
        WarLogger.getInstance().logWarOutcome(gameNumber, WarLogger.P2);
        end = true;
      }
      battleNumber++;
    }
  }
  /* If two player medians are the same, each player flips one card until
    someone has a higher value card
    */
  private String war()
  {
    // Initialize war variables
    boolean complete = false;
    String win = "";
    int valueOne;
    int valueTwo;
    int iterate = 0;
    LinkedList<Card> addCards = new LinkedList<Card>();
    // While a war has not been won
    while (!complete)
    {
      iterate++;
      // If a second war is needed, increment doubleWars
      if (iterate == 2)
      {
        doubleWars++;
      }
      // If playerhand is not empty flip a card
      if (!one.ownedCards.isEmpty())
      {
        Card first = one.flip();
        addCards.addLast(first);
        valueOne = first.getValue();
      }
      // If the hand is empty the value of the players card is set to 0
      else
      {
        valueOne = 0;
      }
      // If playerhand is not empty flip a card
      if (!two.ownedCards.isEmpty())
      {
        Card second = two.flip();
        addCards.addLast(second);
        valueTwo = second.getValue();
      }
      // If the hand is empty the value of the players card is set to 0
      else
      {
        valueTwo = 0;
      }
      // Checks to see who won by comparing card values
      if (valueOne > valueTwo)
      {
        one.collect(addCards);
        WarLogger.getInstance().logWarOutcome(gameNumber, WarLogger.P1);
        complete = true;
        win = "One";
      }
      else if (valueTwo > valueOne)
      {
        two.collect(addCards);
        WarLogger.getInstance().logWarOutcome(gameNumber, WarLogger.P2);
        complete = true;
        win = "Two";
      }
      // Increment wars when a war finishes
      wars++;
    }
    return win;
  }
}
