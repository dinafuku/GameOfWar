/*
Dylan Inafuku
2375529
dinafuku@chapman.edu
CPSC 231-02
MP3: Modern War(fare)
*/
public class Card
{
  // Member variables
  int value; // 2-10, J = 11; Q = 12; K = 13; A = 14
  String suit; // clubs, diamonds, hearts, spades

  // Default constructor
  public Card()
  {
    value = 0;
    suit = null;
  }
  // Overloaded constructor
  public Card(int value, String suit)
  {
    this.value = value;
    this.suit = suit;
  }
  // Accessors
  public int getValue()
  {
    return value;
  }
  public String getSuit()
  {
    return suit;
  }
  // Mutators
  public void setInt(int value)
  {
    this.value = value;
  }
  public void setSuit(String suit)
  {
    this.suit = suit;
  }
  // toString to print cards neatly, used in testing/debugging
  public String toString()
  {
    if (value == 11)
    {
      return "J" + suit;
    }
    if (value == 12)
    {
      return "Q" + suit;
    }
    if (value == 13)
    {
      return "K" + suit;
    }
    if (value == 14)
    {
      return "A" + suit;
    }
    else
    {
      return value + suit;
    }
  }
}
