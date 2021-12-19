
public class Player {
private String name;
private int lives;
private int score;
private int amountSolved;

/**
 * create a player with given lives
 * @param lives this player's lives is assigned to (see constants).
 * @param score this player's current score
 */

public Player(){
    this.name = "Player 1";
    this.lives = 7;
    this.score = 0;
    this.amountSolved = 0;
}

public Player(String name, int lives, int score, int amountSolved){
    this.name = name;
    this.lives = lives;
    this.score = score;
    this.amountSolved = amountSolved;
}

public String getName() { return name; }
public int getScore() { return score; }
public int getLives() {return lives; }
public int getAmountSolved() {return amountSolved; }
public void setName(String name){ this.name  = name;}
public void setLives(int lives){ this.lives  = lives;}
public void setScore(int score){ this.score  = score;}
public void setAmountSolved(){ ++amountSolved;}

}