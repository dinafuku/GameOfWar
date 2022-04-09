/*
Dylan Inafuku
2375529
dinafuku@chapman.edu
CPSC 231-02
MP3: Modern War(fare)
*/

import java.util.*;

public class Simulation
{
  //Instance variables
  int numGames;
  int averageBattles;
  int averageWars;
  int averageDoubleWars;
  int maxBattles;
  int minBattles;
  int maxWars;
  int minWars;
  int counter;
  int doubleWars;

  public static void main(String[] args)
  {
    // Prompts user for input of games
    Scanner kb = new Scanner(System.in);
    System.out.println("How many games would you like to simulate?");
    int input = kb.nextInt();
    // Creates a simulation of given input
    Simulation one = new Simulation(input);
    System.out.println();
    // Simulates and reports the games
    one.simulate();
    one.report();
    WarLogger.getInstance().release();
  }
  //Default constructor
  public Simulation()
  {
    numGames = 0;
    averageBattles = 0;
    averageWars = 0;
    averageDoubleWars = 0;
    maxBattles = 0;
    minBattles = 10000;
    maxWars = 0;
    minWars = 10000;
    counter = 0;
    doubleWars = 0;
  }
  //Overloaded constructor
  public Simulation(int numGames)
  {
    this.numGames = numGames;
    averageBattles = 0;
    averageWars = 0;
    averageDoubleWars = 0;
    maxBattles = 0;
    minBattles = 10000;
    maxWars = 0;
    minWars = 10000;
    counter = 0;
    doubleWars = 0;
  }

  // Accessors
  public int getNumGames()
  {
    return numGames;
  }
  public int getAverageBattles()
  {
    return averageBattles;
  }
  public int getAverageWars()
  {
    return averageWars;
  }
  public int getAverageDoubleWars()
  {
    return averageDoubleWars;
  }
  public int getMaxBattles()
  {
    return maxBattles;
  }
  public int getMinBattles()
  {
    return minBattles;
  }
  public int getMaxWars()
  {
    return maxWars;
  }
  public int getMinWars()
  {
    return minWars;
  }
  public int counter()
  {
    return counter;
  }
  public int doubleWars()
  {
    return doubleWars;
  }
  // Mutators
  public void setNumGames(int numGames)
  {
    this.numGames = numGames;
  }
  public void setAverageBattles(int averageBattles)
  {
    this.averageBattles = averageBattles;
  }
  public void setAverageWars(int averageWars)
  {
    this.averageWars = averageWars;
  }
  public void setAverageDoubleWars(int averageDoubleWars)
  {
    this.averageDoubleWars = averageDoubleWars;
  }
  public void setMaxBattles(int maxBattles)
  {
    this.maxBattles = maxBattles;
  }
  public void setMinBattles(int minBattles)
  {
    this.minBattles = minBattles;
  }
  public void setMaxWars(int maxWars)
  {
    this.maxWars = maxWars;
  }
  public void setMinWars(int minWars)
  {
    this.minWars = minWars;
  }
  public void setCounter(int counter)
  {
    this.counter = counter;
  }
  public void setDoubleWars(int doubleWars)
  {
    this.doubleWars = doubleWars;
  }


  // Calculates averages and mins/maxes
  private void calculate(Game game)
  {
    // Adds to running total of battles, wars and double wars
    counter++;
    averageBattles += game.battles;
    averageWars += game.wars;
    averageDoubleWars += game.doubleWars;
    doubleWars += game.doubleWars;
    // If calculate has been called numGames times, find averages
    if (counter == numGames)
    {
      averageBattles /= numGames;
      averageWars /= numGames;
      averageDoubleWars /= numGames;
    }

    /* If the number of wars are battle are higher than previous games,
      set them to min or max battles or wars
      */
    if (game.battles > maxBattles)
    {
      maxBattles = game.battles;
    }
    if (game.battles < minBattles)
    {
      minBattles = game.battles;
    }
    if (game.wars > maxWars)
    {
      maxWars = game.wars;
    }
    if (game.wars < minWars)
    {
      minWars = game.wars;
    }
  }
  // Prints out stats from the games
  private void report()
  {
    System.out.println("Number of games: " + numGames);
    System.out.println("Average number of battles per game: " + averageBattles);
    System.out.println("Average number of wars per game: " + averageWars);
    System.out.println("Number of double wars: " + doubleWars);
    System.out.println("Average number of double wars per game: " + averageDoubleWars);
    System.out.println("Max number of battles in a game: " + maxBattles);
    System.out.println("Min number of battles in a game: " + minBattles);
    System.out.println("Max number of wars in a game: " + maxWars);
    System.out.println("Min number of wars in a game: " + minWars);
    System.out.println();
  }
  // Simulates numGames amount of games
  private void simulate()
  {
    for (int i = 1, n = numGames; i <= n; i++)
    {
      Game current = new Game(i);
      current.play();
      calculate(current);
    }
  }
}
