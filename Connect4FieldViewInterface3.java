package hw6_2;
/**
 * A Program to Create a Player class & implement the PlayerInterface.
 	Implement a Human vs Computer Game

 * @author Aishwary Pramanik
 * @author Shashank Gangadhara
 * @version 2.0
 */
//A public interface with some methods to be implemented
public interface Connect4FieldViewInterface3 {

// this is how your constructor has to be
// Player(Connect4FieldInterface theField, String name, char gamePiece)
	
	public char getGamePiece();
	public String getName();
	public int  nextMove();
}