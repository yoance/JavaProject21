package TypeShootGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
private String name;
private int healthPoints;
private int score;

/**
 * create a player with given healthPoints
 * @param healthPoints this player's healthPoints is assigned to (see constants).
 * @param score this player's current score
 */
public Player(String name, int healthPoints, int score){
    this.name = name;
    this.healthPoints = healthPoints;
    this.score = score;
}

public Player(){
    this.name = "Player 1";
    this.healthPoints = 3;
    this.score = 0;
}

/**
 * get the score this player has.
 * @return the score this player has.
 */
public int getScore() { return score; }

/**
 * get the healthPoints for this player.
 * @return the healthPoints for this player.
 */
public int getHealthPoints() {return healthPoints; }

/**
 * get the name of this player.
 * @return the name of this player.
 */
public String getName() { return name; }

public void setName(String name){ this.name  = name;}
public void setHealthPoints(int healthPoints){ this.healthPoints  = healthPoints;}
public void setScore(int score){ this.score  = score;}
}